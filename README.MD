# README
## General information
A simulation of 100 rock-paper-scissors games with one player always choosing rock and the other player choosing randomly with a print to the console of the simulation results - written in Kotlin.

## Gradle
This project uses [gradle](https://gradle.org/) as the build tool. If you do not have an installation of gradle on your local machine, you can always use the provided gradle-wrapper(`gradlew`) instead (e.g instead of running `gradle clean build` you could run `./gradlew clean build` to use the wrapper). 

## Usage
### Building and running the JAR
Run a `gradle clean build`, go to the `./build/libs` folder and execute the generated jar-file to run a simulation.

### Invoking the main-method in an IDE
Run `RPS::main`.

## Tests
Run `gradle clean test` to run all tests using a clean build.

