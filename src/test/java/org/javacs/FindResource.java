package org.javacs;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Find java sources in maven-project */
public class FindResource {
    public static URI uri(String resourcePath) {
        var path = path(resourcePath);
        return path.toUri();
    }

    public static Path path(String resourcePath) {
        if (resourcePath.startsWith("/")) resourcePath = resourcePath.substring(1);
        Path maven = LanguageServerFixture.getDefaultWorkspaceRoot();
        return maven.resolve("src").resolve(resourcePath).toAbsolutePath().normalize();
    }
}
