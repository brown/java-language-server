package org.javacs;

import com.google.devtools.build.runfiles.AutoBazelRepository;
import com.google.devtools.build.runfiles.Runfiles;
import com.google.gson.JsonElement;

import org.javacs.lsp.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.logging.Logger;

@AutoBazelRepository
public class LanguageServerFixture {
    static {
        Main.setRootFormat();
    }

    public static Path getDefaultWorkspaceRoot() {
        try {
            Runfiles.Preloaded runfiles = Runfiles.preload();
            return Paths.get(
                    runfiles.withSourceRepository(AutoBazelRepository_LanguageServerFixture.NAME)
                            .rlocation("jls/src/test/examples/maven-project"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static CompilerProvider getCompilerProvider() {
        return getJavaLanguageServer().compiler();
    }

    static JavaLanguageServer getJavaLanguageServer() {
        return getJavaLanguageServer(
                getDefaultWorkspaceRoot(), diagnostic -> LOG.info(diagnostic.message));
    }

    static JavaLanguageServer getJavaLanguageServer(Consumer<Diagnostic> onError) {
        return getJavaLanguageServer(getDefaultWorkspaceRoot(), onError);
    }

    static JavaLanguageServer getJavaLanguageServer(
            Path workspaceRoot, Consumer<Diagnostic> onError) {
        return getJavaLanguageServer(
                workspaceRoot,
                new LanguageClient() {
                    @Override
                    public void publishDiagnostics(PublishDiagnosticsParams params) {
                        params.diagnostics.forEach(onError);
                    }

                    @Override
                    public void showMessage(ShowMessageParams params) {}

                    @Override
                    public void registerCapability(String method, JsonElement options) {}

                    @Override
                    public void customNotification(String method, JsonElement params) {}
                });
    }

    static JavaLanguageServer getJavaLanguageServer(Path workspaceRoot, LanguageClient client) {
        FileStore.reset();

        var server = new JavaLanguageServer(client);
        var init = new InitializeParams();

        init.rootUri = workspaceRoot.toUri();
        server.initialize(init);
        server.initialized();

        return server;
    }

    private static final Logger LOG = Logger.getLogger("main");
}
