package de.merv.kata.rps

import de.merv.kata.rps.Shape.*
import io.kotlintest.data.forall
import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class RoundSpec : StringSpec() {

    companion object {
        private val WIN = Triple(1, 0, 0)
        private val DRAW = Triple(0, 1, 0)
        private val LOSE = Triple(0, 0, 1)
    }

    init {
        "A round with two equal shapes should always be evaluated as a draw" {
            assertAll(ShapeGenerator()) { shape ->
                Round.play(shape, shape) shouldBe DRAW
            }
        }

        "A round with a winner should evaluate according to the rules" {
            forall(
                    row(ROCK, PAPER, LOSE),
                    row(ROCK, SCISSORS, WIN),
                    row(PAPER, ROCK, WIN),
                    row(PAPER, SCISSORS, LOSE),
                    row(SCISSORS, ROCK, LOSE),
                    row(SCISSORS, PAPER, WIN)
            ) { shapeOne, shapeTwo, expected ->
                Round.play(shapeOne, shapeTwo) shouldBe expected
            }
        }
    }
}
