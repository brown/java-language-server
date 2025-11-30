load("@rules_java//java:defs.bzl", "java_library", "java_test")

OPEN_JDK_COMPILER = [
    "--add-opens=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
    "--add-opens=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
    "--add-opens=jdk.compiler/com.sun.tools.javac.comp=ALL-UNNAMED",
    "--add-opens=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED",
    "--add-opens=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
    "--add-opens=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
    "--add-opens=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
]

java_library(
    name = "javacs",
    srcs = [
        "CompletionsBase.java",
        "FindResource.java",
        "LanguageServerFixture.java",
    ],
    data = [
        "//src/test/examples/maven-project",  # for FindResource and LanguageServerFixture
    ],
    deps = [
        "//src/main/java/org/javacs",
        "@bazel_tools//tools/java/runfiles",
        "@maven//:com_google_code_gson_gson",
        "@maven//:junit_junit",
    ],
)

java_test(
    name = "ArtifactTest",
    timeout = "short",
    srcs = ["ArtifactTest.java"],
    deps = [
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "ClassesTest",
    timeout = "short",
    srcs = ["ClassesTest.java"],
    deps = [
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "CodeActionTest",
    timeout = "moderate",
    srcs = ["CodeActionTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "CodeLensTest",
    timeout = "moderate",
    srcs = ["CodeLensTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "CompletionsScopesTest",
    timeout = "moderate",
    srcs = ["CompletionsScopesTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "CompletionsTest",
    timeout = "moderate",
    srcs = ["CompletionsTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "FileStoreTest",
    timeout = "short",
    srcs = ["FileStoreTest.java"],
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "FindReferencesTest",
    timeout = "moderate",
    srcs = ["FindReferencesTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "FindSrcZipTest",
    timeout = "short",
    srcs = ["FindSrcZipTest.java"],
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "GotoTest",
    timeout = "moderate",
    srcs = ["GotoTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "HoverTest",
    timeout = "moderate",
    srcs = ["HoverTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "IncrementalCompileTest",
    timeout = "short",
    srcs = ["IncrementalCompileTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        "//src/main/java/org/javacs",
        "@bazel_tools//tools/java/runfiles",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "InferBazelConfigTest",
    timeout = "short",
    srcs = ["InferBazelConfigTest.java"],
    data = [
        "//src/test/examples/bazel-project",
    ],
    deps = [
        "//src/main/java/org/javacs",
        "@bazel_tools//tools/java/runfiles",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "InferConfigTest",
    timeout = "short",
    srcs = ["InferConfigTest.java"],
    data = [
        "//src/test/examples/home-dir",
    ],
    deps = [
        "//src/main/java/org/javacs",
        "@bazel_tools//tools/java/runfiles",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "JavaCompilerServiceTest",
    timeout = "short",
    srcs = ["JavaCompilerServiceTest.java"],
    data = [
        "//src/test/examples/simple-project",
    ],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        "//src/main/java/org/javacs",
        "@bazel_tools//tools/java/runfiles",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "JavaDebugServerTest",
    timeout = "short",
    srcs = ["JavaDebugServerTest.java"],
    data = [
        "//src/test/examples/debug",
    ],
    deps = [
        "//src/main/java/org/javacs",
        "@bazel_tools//tools/java/runfiles",
    ],
)

java_test(
    name = "JavaLanguageServerTest",
    timeout = "moderate",
    srcs = ["JavaLanguageServerTest.java"],
    data = [
        "//src/test/examples/missing-type-identifier",
    ],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@bazel_tools//tools/java/runfiles",
    ],
)

java_test(
    name = "MarkdownHelperTest",
    timeout = "short",
    srcs = ["MarkdownHelperTest.java"],
    deps = [
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "SearchTest",
    timeout = "moderate",
    srcs = ["SearchTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "SemanticColorsTest",
    timeout = "moderate",
    srcs = ["SemanticColorsTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:com_google_code_gson_gson",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "SignatureHelpTest",
    timeout = "moderate",
    srcs = ["SignatureHelpTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "SourceFileManagerTest",
    timeout = "short",
    srcs = ["SourceFileManagerTest.java"],
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "StringSearchTest",
    timeout = "short",
    srcs = ["StringSearchTest.java"],
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "WarningsTest",
    timeout = "short",
    srcs = ["WarningsTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)
