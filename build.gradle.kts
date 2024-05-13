plugins {
    kotlin("jvm") version "1.9.24"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    application
}

group = "de.merv.kata"
version = "1.0"

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("de.merv.kata.rps.RPS")
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
    testImplementation("io.kotest:kotest-runner-junit5:5.8.1")
    testImplementation("io.kotest:kotest-property:5.8.1")
    testImplementation("io.kotest:kotest-framework-datatest:5.8.1")
}
