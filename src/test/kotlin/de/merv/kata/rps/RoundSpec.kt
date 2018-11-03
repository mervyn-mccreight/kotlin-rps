package de.merv.kata.rps

import io.kotlintest.data.forall
import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class RoundSpec : StringSpec() {

    init {
        "A round with two equal shapes should always be evaluated as a draw" {
            assertAll(ShapeGenerator()) { shape ->
                Round.play(shape, shape) shouldBe Triple(0, 1, 0)
            }
        }

        "A round with a winner should evaluate according to the rules" {
            forall(
                    row(Shape.ROCK, Shape.PAPER, Triple(0, 0, 1)),
                    row(Shape.ROCK, Shape.SCISSORS, Triple(1, 0, 0)),
                    row(Shape.PAPER, Shape.ROCK, Triple(1, 0, 0)),
                    row(Shape.PAPER, Shape.SCISSORS, Triple(0, 0, 1)),
                    row(Shape.SCISSORS, Shape.ROCK, Triple(0, 0, 1)),
                    row(Shape.SCISSORS, Shape.PAPER, Triple(1, 0, 0))
            ) { shapeOne, shapeTwo, expected ->
                Round.play(shapeOne, shapeTwo) shouldBe expected
            }
        }
    }
}
