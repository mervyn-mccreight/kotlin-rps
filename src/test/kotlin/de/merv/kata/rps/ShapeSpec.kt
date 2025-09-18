package de.merv.kata.rps

import de.infix.testBalloon.framework.testSuite
import de.merv.kata.rps.Shape.PAPER
import de.merv.kata.rps.Shape.ROCK
import de.merv.kata.rps.Shape.SCISSORS

val ShapeSpec by testSuite {
    data class WinsAgainstTestCase(val challenger: Shape, val opponent: Shape, val expected: Boolean)

    testSuite("should win against each other according to the rules") {
        listOf(
            WinsAgainstTestCase(ROCK, ROCK, false),
            WinsAgainstTestCase(ROCK, PAPER, false),
            WinsAgainstTestCase(ROCK, SCISSORS, true),
            WinsAgainstTestCase(PAPER, ROCK, true),
            WinsAgainstTestCase(PAPER, PAPER, false),
            WinsAgainstTestCase(PAPER, SCISSORS, false),
            WinsAgainstTestCase(SCISSORS, ROCK, false),
            WinsAgainstTestCase(SCISSORS, PAPER, true),
            WinsAgainstTestCase(SCISSORS, SCISSORS, false)
        ).forEach {
            test(it.toString()) {
                assert((it.challenger winsAgainst it.opponent) == it.expected)
            }
        }
    }

    testSuite("One picks a random shape") {
        test("He always picks the same shape if the set of choices only contains one shape") {
            Shape.entries.forEach {
                assert(Shape.pickOneOf(it) == it)
            }
        }

        test("He always picks a shape out of the set of choices and nothing else") {
            repeat(100) {
                val shapeOne = Shape.entries.random()
                val shapeTwo = Shape.entries.random()

                val pick = Shape.pickOneOf(shapeOne, shapeTwo)
                assert(pick == shapeOne || pick == shapeTwo)
            }
        }
    }
}
