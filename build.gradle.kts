import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    application
}

group = "de.merv.kata"
version = "1.0"

application {
    mainClass.set("de.merv.kata.rps.RPS")
}

tasks.withType<Test> {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:5.5.3")
    testImplementation("io.kotest:kotest-property:5.4.2")
    testImplementation("io.kotest:kotest-framework-datatest:5.4.2")
}
