plugins {
    kotlin("jvm") version "1.8.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    application
}

group = "de.merv.kata"
version = "1.0"

kotlin {
    jvmToolchain(19)
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
    testImplementation("io.kotest:kotest-runner-junit5:5.6.1")
    testImplementation("io.kotest:kotest-property:5.6.1")
    testImplementation("io.kotest:kotest-framework-datatest:5.6.1")
}
