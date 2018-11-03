package de.merv.kata.rps

import de.merv.kata.rps.Shape.*
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
                    row(ROCK, PAPER, Triple(0, 0, 1)),
                    row(ROCK, SCISSORS, Triple(1, 0, 0)),
                    row(PAPER, ROCK, Triple(1, 0, 0)),
                    row(PAPER, SCISSORS, Triple(0, 0, 1)),
                    row(SCISSORS, ROCK, Triple(0, 0, 1)),
                    row(SCISSORS, PAPER, Triple(1, 0, 0))
            ) { shapeOne, shapeTwo, expected ->
                Round.play(shapeOne, shapeTwo) shouldBe expected
            }
        }
    }
}
