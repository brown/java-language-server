load("//:overlay.bzl", "overlay_repo")

overlay = module_extension(
    implementation = lambda ctx: overlay_repo(name = "jls"),
)
