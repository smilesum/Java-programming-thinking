load("@rules_java//java:defs.bzl", "java_binary", "java_library", "java_test")

package(default_visibility = ["//visibility:public"])

app_dependency = [
    "@maven//:org_springframework_boot_spring_boot",
    "@maven//:org_springframework_boot_spring_boot_autoconfigure",
    "@maven//:org_springframework_boot_spring_boot_starter_web",
    "@maven//:org_springframework_spring_context",
    "@maven//:org_springframework_spring_web",
    "@maven//:org_springframework_boot_spring_boot_starter_test",
    "@maven//:commons_logging_commons_logging",
    "@maven//:org_springframework_spring_beans",
    "@maven//:org_springframework_spring_core",
    "@maven//:org_springframework_spring_expression",
    "@maven//:org_springframework_spring_tx",
    "@maven//:org_junit_jupiter_junit_jupiter_api",
    "@maven//:org_apache_tomcat_tomcat_annotations_api",
    "@maven//:org_springframework_boot_spring_boot_starter_data_jpa",
    "@maven//:junit_junit",
    "@maven//:com_h2database_h2",

    #AOP
    "@maven//:org_springframework_spring_aspects",
    "@maven//:org_springframework_boot_spring_boot_starter_aop",
    "@maven//:org_aspectj_aspectjweaver",
    "@maven//:org_springframework_spring_aop",
]

java_library(
    name = "java-maven-lib",
    srcs = glob(["src/main/java/com/**/*.java"]),
    deps = app_dependency,
)

java_binary(
    name = "java-maven",
    srcs = glob(["src/main/java/com/**/*.java"]),
    main_class = "src.main.java.com.Spring.SpringBoot.App",
    deps = app_dependency,
)

java_binary(
    name = "java-src",
    srcs = glob(["src/main/java/com/**/*.java"]),
    main_class = "src.main.java.com.Java.stream.StreamExample",
    deps = app_dependency,
)

java_binary(
    name = "java-test",
    srcs = glob(["src/main/java/com/**/*.java"]),
    main_class = "src.main.java.com.Java.annotation.Test",
    deps = app_dependency,
)

java_binary(
    name = "java-java8",
    srcs = glob(["src/main/java/com/**/*.java"]),
    main_class = "src.main.java.com.Java8.Interface.TestDefault",
    deps = app_dependency,
)

java_binary(
    name = "java-spring",
    srcs = glob(["src/main/java/com/**/*.java"]),
    main_class = "src.main.java.com.Spring.AOP.Exception.AppConfig",
    deps = app_dependency,
)

java_test(
    name = "tests",
    srcs = glob(["src/test/java/com/**/*.java"]),
    test_class = "src.test.java.com.Spring.SpringBoot.HelloControllerTest",
    deps = app_dependency + [
        ":java-maven-lib",
        "@maven//:org_springframework_boot_spring_boot_test",
        "@maven//:org_assertj_assertj_core",
    ],
)