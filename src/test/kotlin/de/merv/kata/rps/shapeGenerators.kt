package de.merv.kata.rps

import io.kotest.property.arbitrary.arbitrary
import io.kotest.property.exhaustive.exhaustive

private val possibleShapes = enumValues<Shape>().toList()

val shapeArbitrary = arbitrary { randomSource ->
    possibleShapes.shuffled(randomSource.random).first()
}

val shapeExhaustive = possibleShapes.exhaustive()
