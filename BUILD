load("@rules_java//java:defs.bzl", "java_binary", "java_library", "java_test")

package(default_visibility = ["//visibility:public"])

app_dependencies = [
    "@maven//:org_springframework_boot_spring_boot_starter_web",
    "@maven//:org_springframework_boot_spring_boot",
    "@maven//:org_springframework_boot_spring_boot_autoconfigure",
    "@maven//:org_springframework_boot_spring_boot_starter_data_jpa",
    "@maven//:org_springframework_boot_spring_boot_starter_security",
    "@maven//:org_springframework_data_spring_data_commons",
    "@maven//:org_springframework_data_spring_data_jpa",
    "@maven//:org_springframework_security_spring_security_config",
    "@maven//:org_springframework_security_spring_security_web",
    "@maven//:org_springframework_spring_beans",
    "@maven//:org_springframework_spring_context",
    "@maven//:org_springframework_spring_core",
    "@maven//:org_springframework_spring_expression",
    "@maven//:org_springframework_spring_tx",
    "@maven//:org_springframework_spring_web",
    "@maven//:org_springframework_spring_webmvc",
]

java_library(
    name = "java-maven-lib",
    srcs = glob(["src/main/java/com/**/*.java"]),
    deps = app_dependencies,
)

java_binary(
    name = "java-maven",
    main_class = "src.main.java.com.Spring.SpringBoot.App",
    runtime_deps = [":java-maven-lib"],
)

java_test(
    name = "tests",
    srcs = glob(["src/test/java/com/**/*.java"]),
    test_class = "src.test.java.com.Spring.SpringBoot.TestApp",
    deps = [
        ":java-maven-lib",
        "@maven//:com_google_guava_guava",
        "@maven//:org_junit_jupiter_junit_jupiter_migrationsupport",
        "@maven//:junit_junit",
        "@maven//:org_springframework_boot_spring_boot_test",
    ] + app_dependencies,
)