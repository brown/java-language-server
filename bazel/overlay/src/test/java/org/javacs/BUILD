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
        "//src/test/examples/maven-project",  # for LanguageServerFixture
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
    size = "small",
    srcs = ["ArtifactTest.java"],
    deps = [
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "ClassesTest",
    size = "small",
    srcs = ["ClassesTest.java"],
    deps = [
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "CodeActionTest",
    size = "small",
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
    size = "small",
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
    size = "small",
    srcs = ["CompletionsScopesTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "CompletionsTest",
    size = "medium",
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
    size = "small",
    srcs = ["FileStoreTest.java"],
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "FindReferencesTest",
    size = "medium",
    srcs = ["FindReferencesTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "GotoTest",
    size = "small",
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
    size = "small",
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
    size = "small",
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
    size = "small",
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
    size = "small",
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
    size = "small",
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
    size = "small",
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
    size = "small",
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
    size = "small",
    srcs = ["MarkdownHelperTest.java"],
    deps = [
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "SearchTest",
    size = "small",
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
    size = "small",
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
    size = "small",
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
    size = "small",
    srcs = ["SourceFileManagerTest.java"],
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "StringSearchTest",
    size = "small",
    srcs = ["StringSearchTest.java"],
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)

java_test(
    name = "WarningsTest",
    size = "small",
    srcs = ["WarningsTest.java"],
    jvm_flags = OPEN_JDK_COMPILER,
    deps = [
        ":javacs",
        "//src/main/java/org/javacs",
        "@maven//:org_hamcrest_hamcrest_all",
    ],
)
