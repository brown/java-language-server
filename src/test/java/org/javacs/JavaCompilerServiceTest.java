package org.javacs;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import com.google.devtools.build.runfiles.Runfiles;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import org.junit.*;

public class JavaCompilerServiceTest {
    static {
        Main.setRootFormat();
    }

    private JavaCompilerService compiler =
            new JavaCompilerService(Collections.emptySet(), Collections.emptySet(), Collections.emptySet());

    static Path simpleProjectSrc() {
        try {
            return Paths.get(Runfiles.create().rlocation(
                                 "jls/src/test/examples/simple-project"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void setWorkspaceRoot() {
        FileStore.setWorkspaceRoots(Set.of(simpleProjectSrc()));
    }

    @Test
    public void emptyTest() {
    }
}
