filegroup(
    name = "bazel-project",
    srcs = glob(
        [
            ".gitignore",
            # Directory hello contains a BUILD file, which normally terminates
            # the recursive glob.  We run "bazel test" with flag
            # "--deleted_packages=@jls//src/test/examples/bazel-project/hello"
            # so the contents of the hello directory are matched by the glob.
            "hello/**",
            "output.txt",
            "WORKSPACE",
        ],
        allow_empty = True,
    ),
    visibility = ["//visibility:public"],
)
