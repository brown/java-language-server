def _overlay_tree(repository_ctx):
    # src_path = repository_ctx.path(Label("//:WORKSPACE")).dirname
    # bazel_path = src_path.get_child("bazel")

    bazel_path = repository_ctx.path(Label("//:WORKSPACE")).dirname
    src_path = bazel_path.get_child("..")
    overlay_path = bazel_path.get_child("overlay")
    script_path = bazel_path.get_child("overlay_tree.py")

    python_bin = repository_ctx.which("python3")
    if not python_bin:
        # Windows typically just defines "python" as python3. The script itself
        # contains a check to ensure python3.
        python_bin = repository_ctx.which("python")

    if not python_bin:
        fail("Failed to find python3 binary")

    cmd = [
        python_bin,
        script_path,
        "--src",
        src_path,
        "--overlay",
        overlay_path,
        "--target",
        ".",
    ]
    exec_result = repository_ctx.execute(cmd, timeout = 20)

    if exec_result.return_code != 0:
        fail(("Failed to execute overlay script: '{cmd}'\n" +
              "Exited with code {return_code}\n" +
              "stdout:\n{stdout}\n" +
              "stderr:\n{stderr}\n").format(
            cmd = " ".join([str(arg) for arg in cmd]),
            return_code = exec_result.return_code,
            stdout = exec_result.stdout,
            stderr = exec_result.stderr,
        ))

def _overlay_impl(repository_ctx):
    _overlay_tree(repository_ctx)

overlay_repo = repository_rule(
    implementation = _overlay_impl,
    local = True,
    configure = True,
)
