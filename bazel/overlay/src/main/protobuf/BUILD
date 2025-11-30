load("@protobuf//bazel:java_proto_library.bzl", "java_proto_library")
load("@protobuf//bazel:proto_library.bzl", "proto_library")

java_proto_library(
    name = "analysis_java_proto",
    visibility = ["//visibility:public"],
    deps = [":analysis_proto"],
)

proto_library(
    name = "analysis_proto",
    srcs = ["analysis.proto"],
    deps = [":build_proto"],
)

java_proto_library(
    name = "analysis_v2_java_proto",
    visibility = ["//visibility:public"],
    deps = [":analysis_v2_proto"],
)

proto_library(
    name = "analysis_v2_proto",
    srcs = ["analysis_v2.proto"],
    deps = [":build_proto"],
)

proto_library(
    name = "build_proto",
    srcs = ["build.proto"],
)
