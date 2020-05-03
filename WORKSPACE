load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "3.0"
RULES_JVM_EXTERNAL_SHA = "62133c125bf4109dfd9d2af64830208356ce4ef8b165a6ef15bbff7460b35c3a"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)
SPRING_VERSION = "5.2.0.RELEASE"

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "org.hamcrest:hamcrest-library:1.3",
        "org.springframework.boot:spring-boot-autoconfigure:2.1.3.RELEASE",
        "org.springframework.boot:spring-boot-test-autoconfigure:2.1.3.RELEASE",
        "org.springframework.boot:spring-boot-test:2.1.3.RELEASE",
        "org.springframework.boot:spring-boot:2.1.3.RELEASE",
        "org.springframework.boot:spring-boot-starter-web:2.1.3.RELEASE",
        "org.springframework:spring-beans:5.1.5.RELEASE",
        "org.springframework:spring-context:5.1.5.RELEASE",
        "org.springframework:spring-test:5.1.5.RELEASE",
        "org.springframework:spring-web:5.1.5.RELEASE",
        "org.junit.jupiter:junit-jupiter-api:5.6.0",
        "org.springframework.boot:spring-boot-starter-test:2.2.6.RELEASE",
        "commons-logging:commons-logging:1.2",
        "org.springframework:spring-aop:5.2.0.RELEASE",
        "org.springframework:spring-expression:5.2.0.RELEASE",
        "org.springframework:spring-beans:" + SPRING_VERSION,
        "org.springframework:spring-context:" + SPRING_VERSION,
        "org.springframework:spring-core:" + SPRING_VERSION,
        "org.springframework:spring-test:" + SPRING_VERSION,
        "org.springframework:spring-tx:" + SPRING_VERSION,
        "org.springframework:spring-webflux:" + SPRING_VERSION,
        "org.assertj:assertj-core:" + "3.13.0",
    ],
    fetch_sources = True,
    #maven_install_json = "//:maven_install.json",
    repositories = [
        "https://jcenter.bintray.com",
        "https://repo.spring.io/milestone/",
        "http://repo.maven.apache.org/maven2",
        "https://mvnrepository.com",
    ],
)

load("@maven//:defs.bzl", "pinned_maven_install")
pinned_maven_install()
