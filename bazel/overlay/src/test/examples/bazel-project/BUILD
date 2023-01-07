filegroup(
    name = "bazel-project",
    srcs = glob([
        ".gitignore",
        # XXXXXXXXXX This does not work, because the hello directory contains a
        # BUILD file, which terminates the recursive glob.
        "hello/**",
        "output.txt",
        "WORKSPACE",
    ]),
    visibility = ["//visibility:public"],
)
