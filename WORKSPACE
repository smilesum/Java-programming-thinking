load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "2.5"

RULES_JVM_EXTERNAL_SHA = "249e8129914be6d987ca57754516be35a14ea866c616041ff0cd32ea94d2f3a1"
GRPC_VERSION = "1.27.0"

JACKSON_VERSION = "2.10.2"

JOOQ_VERSION = "3.12.4"

REACTOR_CORE_VERSION = "3.3.2.RELEASE"

RULES_JVM_EXTERNAL_VERSION = "3.0"

SLF4J_VERSION = "1.7.30"

SPRING_VERSION = "5.2.3.RELEASE"

SPRING_BOOT_VERSION = "2.2.4.RELEASE"

SPRING_R2DBC_STARTER_VERSION = "0.1.0.M3"

FLYWAY_CORE_VERSION = "6.0.8"

SHEDLOCK_VERSION = "4.5.1"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)


SPRING_BOOT_VERSION = "2.2.4.RELEASE"

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:specs.bzl", "maven")

maven_install(
    artifacts = [
        "junit:junit:4.12",
        "com.google.guava:guava:28.0-jre",
        "org.springframework.boot:spring-boot-actuator-autoconfigure:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-actuator:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-autoconfigure:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-configuration-processor:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-devtools:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-devtools:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-loader:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-starter-actuator:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-starter-aop:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-starter-data-jpa:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-starter-security:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-starter-test:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-starter-validation:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-starter-web:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-starter-cache:" + SPRING_BOOT_VERSION,
        maven.artifact(
            group = "org.springframework.boot",
            artifact = "spring-boot-starter-webflux",
            version = SPRING_BOOT_VERSION,
            exclusions = [
                "io.projectreactor.netty:reactor-netty",
            ],
        ),
        maven.artifact(
            group = "org.springframework.boot",
            artifact = "spring-boot-starter-tomcat",
            version = SPRING_BOOT_VERSION,
            exclusions = [
                "org.apache.tomcat.embed:tomcat-embed-websocket",
            ],
        ),
        "org.springframework.boot:spring-boot-test-autoconfigure:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-test:" + SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot:" + SPRING_BOOT_VERSION,
        "org.springframework.data:spring-data-r2dbc:1.0.0.RELEASE",
        "org.springframework.data:spring-data-relational:1.1.5.RELEASE",
        "org.springframework.security:spring-security-test:5.2.1.RELEASE",
        "org.springframework:spring-beans:" + SPRING_VERSION,
        "org.springframework:spring-context:" + SPRING_VERSION,
        "org.springframework:spring-core:" + SPRING_VERSION,
        "org.springframework:spring-test:" + SPRING_VERSION,
        "org.springframework:spring-tx:" + SPRING_VERSION,
        "org.springframework:spring-webflux:" + SPRING_VERSION,
        "org.junit.jupiter:junit-jupiter-migrationsupport:5.2.0",
        "org.junit.jupiter:junit-jupiter:5.5.2",
    ],
    fetch_sources = True,
    repositories = [
        "http://uk.maven.org/maven2",
        "https://jcenter.bintray.com/",
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)