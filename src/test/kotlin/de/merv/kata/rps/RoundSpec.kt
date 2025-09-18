package de.merv.kata.rps

import de.infix.testBalloon.framework.testSuite
import de.merv.kata.rps.Shape.PAPER
import de.merv.kata.rps.Shape.ROCK
import de.merv.kata.rps.Shape.SCISSORS

val RoundSpec by testSuite {
    testSuite("A round with two equal shapes should always be evaluated as a draw") {
        Shape
            .entries
            .map { Draw(it, it) }
            .forEach {
                test(it.toString()) {
                    assert(Round.play(it.challenger, it.opponent) == it.expectedResult())
                }
            }
    }

    testSuite("A round with a winner should evaluate according to the rules") {
        listOf(
            Loss(ROCK, PAPER),
            Win(ROCK, SCISSORS),
            Win(PAPER, ROCK),
            Loss(PAPER, SCISSORS),
            Loss(SCISSORS, ROCK),
            Win(SCISSORS, PAPER),
        ).forEach {
            test(it.toString()) {
                assert(Round.play(it.challenger, it.opponent) == it.expectedResult())
            }
        }
    }
}

private sealed interface RulesTestCase {
    val challenger: Shape
    val opponent: Shape
    fun expectedResult(): Triple<Int, Int, Int>
}

private data class Win(override val challenger: Shape, override val opponent: Shape) : RulesTestCase {
    override fun expectedResult(): Triple<Int, Int, Int> = Triple(1, 0, 0)
}

private data class Loss(override val challenger: Shape, override val opponent: Shape) : RulesTestCase {
    override fun expectedResult(): Triple<Int, Int, Int> = Triple(0, 0, 1)
}

private data class Draw(override val challenger: Shape, override val opponent: Shape) : RulesTestCase {
    override fun expectedResult(): Triple<Int, Int, Int> = Triple(0, 1, 0)
}
