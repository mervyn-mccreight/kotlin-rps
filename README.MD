# README

## General information

A simulation of 100 rock-paper-scissors games with one player always choosing rock and the other player choosing
randomly with a print to the console of the simulation results - written in Kotlin.

## Gradle

This project uses [gradle](https://gradle.org/) as the build tool. If you do not have an installation of gradle on your
local machine, you can always use the provided gradle-wrapper(`gradlew`) instead (e.g. instead of
running `gradle clean build` you could run `./gradlew clean build` to use the wrapper).

## Usage

### Run simulation using gradle

To run a simulation execute `gradle run`. This will run the application.

### Building and running application manually

1) Run a `gradle installDist` package a ready-to-use version of the application
2) Go to the `./build/install/kotlin-rps/bin` folder and execute `kotlin-rps` to run a simulation

### Invoking the main-method in an IDE

Run `RPS::main`.

## Tests

Run `gradle test` to run all verifications.
