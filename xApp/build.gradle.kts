plugins {
    alias(libs.plugins.kotlin.jvm)
    application
}

application {
    mainClass.set("MainKt")
}

val jdkVersion = libs.versions.jdk.get().toInt()

group = "x.project"
version = "unspecified"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(jdkVersion))
    }
}

kotlin {
    jvmToolchain(jdkVersion)
}

dependencies {
    implementation(project(":xLib"))
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.logback.classic)
    implementation(libs.kotlin.logging)
    implementation(libs.logstash.logback.encoder)
}