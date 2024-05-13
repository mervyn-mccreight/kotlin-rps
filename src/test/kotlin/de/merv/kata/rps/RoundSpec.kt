package de.merv.kata.rps

import de.merv.kata.rps.Shape.PAPER
import de.merv.kata.rps.Shape.ROCK
import de.merv.kata.rps.Shape.SCISSORS
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.property.Exhaustive
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.enum

class RoundSpec : FunSpec() {

    companion object {
        private val WIN = Triple(1, 0, 0)
        private val DRAW = Triple(0, 1, 0)
        private val LOSE = Triple(0, 0, 1)
    }

    init {
        test("A round with two equal shapes should always be evaluated as a draw") {
            checkAll(Exhaustive.enum()) { shape: Shape ->
                Round.play(shape, shape) shouldBe DRAW
            }
        }

        context("A round with a winner should evaluate according to the rules") {
            data class RulesTestCase(
                val challenger: Shape,
                val opponent: Shape,
                val expectedResult: Triple<Int, Int, Int>
            )
            withData(
                RulesTestCase(ROCK, PAPER, LOSE),
                RulesTestCase(ROCK, SCISSORS, WIN),
                RulesTestCase(PAPER, ROCK, WIN),
                RulesTestCase(PAPER, SCISSORS, LOSE),
                RulesTestCase(SCISSORS, ROCK, LOSE),
                RulesTestCase(SCISSORS, PAPER, WIN)
            ) { (challenger, opponent, expectedResult) ->
                Round.play(challenger, opponent) shouldBe expectedResult
            }
        }
    }
}
