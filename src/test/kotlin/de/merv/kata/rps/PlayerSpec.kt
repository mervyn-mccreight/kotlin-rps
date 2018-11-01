package de.merv.kata.rps

import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class PlayerSpec : StringSpec() {

    init {
        "A player with only one choice should always play exactly this choice" {
            forAll(ShapeGenerator()) { singleShape: Shape ->
                Player().playOneOf(singleShape) == singleShape
            }
        }

        "A player with more choices should always play one of the given choices" {
            forAll(ShapeGenerator(), ShapeGenerator()) { shapeOne: Shape, shapeTwo: Shape ->
                val chosenShape = Player().playOneOf(shapeOne, shapeTwo)
                chosenShape == shapeOne || chosenShape == shapeTwo
            }
        }
    }
}

private class ShapeGenerator : Gen<Shape> {

    override fun constants(): Iterable<Shape> = enumValues<Shape>().toList()

    override fun random(): Sequence<Shape> = generateSequence {
        enumValues<Shape>().toList().shuffled().first()
    }
}