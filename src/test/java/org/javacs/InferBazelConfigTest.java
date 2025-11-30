package org.javacs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.google.devtools.build.runfiles.AutoBazelRepository;
import com.google.devtools.build.runfiles.Runfiles;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@AutoBazelRepository
public class InferBazelConfigTest {
    public static Path getBazelProjectRoot() {
        try {
            Runfiles.Preloaded runfiles = Runfiles.preload();
            return Paths.get(
                    runfiles.withSourceRepository(AutoBazelRepository_InferBazelConfigTest.NAME)
                            .rlocation("jls/src/test/examples/bazel-project"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Path getBazelProtosProjectRoot() {
        try {
            Runfiles.Preloaded runfiles = Runfiles.preload();
            return Paths.get(
                    runfiles.withSourceRepository(AutoBazelRepository_InferBazelConfigTest.NAME)
                            .rlocation("jls/src/test/examples/bazel-protos-project"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Ignore // XXXXXXXXXXXXXXXXXXXX Bazel
    // BUILD files in bazel-project prevent glob in that dir's overlay BUILD
    // from copying everything
    public void bazelClassPath() {
        var bazel = new InferConfig(Paths.get("src/test/examples/bazel-project"));
        var classPath = bazel.classPath();
        System.out.println("XXXXXXXXXX bazel" + bazel);
        System.out.println("XXXXXXXXXX class path" + bazel.classPath());
        assertThat(classPath, contains(hasToString(endsWith("guava-18.0.jar"))));
    }

    @Test
    @Ignore // XXXXXXXXXXXXXXXXXXXX Bazel
    public void bazelClassPathInSubdir() {
        var bazel = new InferConfig(Paths.get("src/test/examples/bazel-project/hello"));
        var classPath = bazel.classPath();
        assertThat(classPath, contains(hasToString(endsWith("guava-18.0.jar"))));
    }

    @Test
    @Ignore // XXXXXXXXXXXXXXXXXXXX Bazel
    public void bazelClassPathWithProtos() {
        var bazel = new InferConfig(Paths.get("src/test/examples/bazel-protos-project"));
        var classPath = bazel.classPath();
        assertThat(classPath, hasItem(hasToString(endsWith("libperson_proto-speed.jar"))));
    }

    @Test
    @Ignore // XXXXXXXXXXXXXXXXXXXX Bazel
    public void bazelDocPath() {
        var bazel = new InferConfig(Paths.get("src/test/examples/bazel-project"));
        var docPath = bazel.buildDocPath();
        assertThat(docPath, contains(hasToString(endsWith("guava-18.0-sources.jar"))));
    }

    @Test
    @Ignore // XXXXXXXXXXXXXXXXXXXX Bazel
    public void bazelDocPathInSubdir() {
        var bazel = new InferConfig(Paths.get("src/test/examples/bazel-project/hello"));
        assertThat(bazel.buildDocPath(), contains(hasToString(endsWith("guava-18.0-sources.jar"))));
    }

    @Test
    @Ignore // XXXXXXXXXXXXXXXXXXXX Bazel
    public void bazelDocPathWithProtos() {
        var bazel = new InferConfig(Paths.get("src/test/examples/bazel-protos-project"));
        assertThat(
                bazel.buildDocPath(), hasItem(hasToString(endsWith("person_proto-speed-src.jar"))));
    }
}
