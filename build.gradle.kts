plugins {
    alias(libs.plugins.kotlin.jvm)
    application
}

group = "de.merv.kata"
version = "1.0"

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("de.merv.kata.rps.MainKt")
}

tasks.withType<Test> {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.kotest.runner.junit5)
    testImplementation(libs.kotest.property)
    testImplementation(libs.kotest.framework.datatest)
}
