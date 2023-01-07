package org.javacs;

import com.google.devtools.build.runfiles.Runfiles;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import org.javacs.lsp.DidOpenTextDocumentParams;
import org.javacs.lsp.TextDocumentItem;
import org.junit.Test;

public class JavaLanguageServerTest {

    private static String filePath(String relativePath) {
        try {
            return Runfiles.create().rlocation("jls/" + relativePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void LintShouldNotCrashOnCodeWithMissingTypeIdentifier() {
        String filePath = filePath("src/test/examples/missing-type-identifier/Sample.java");
        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.uri = URI.create("file:///" + filePath);
        try {
            textDocument.text = Files.readString(Path.of(filePath));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        textDocument.version = 1;
        textDocument.languageId = "java";
        JavaLanguageServer server = LanguageServerFixture.getJavaLanguageServer();
        server.didOpenTextDocument(new DidOpenTextDocumentParams(textDocument));

        // Should not fail
        server.lint(Collections.singleton(Paths.get(textDocument.uri)));
    }
}
