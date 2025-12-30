import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.powerassert)
    alias(libs.plugins.testballoon)
    application
}

group = "de.merv.kata"
version = "1.0"

kotlin {
    jvmToolchain(25)
    compilerOptions {
        allWarningsAsErrors = true
        progressiveMode = true
    }
}

application {
    mainClass.set("de.merv.kata.rps.MainKt")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()

    testLogging {
        events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.PASSED)
    }
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
powerAssert {
    functions = listOf("kotlin.assert")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.testballoon.framework.core)
}
