package de.merv.kata.rps

import de.merv.kata.rps.Shape.PAPER
import de.merv.kata.rps.Shape.ROCK
import de.merv.kata.rps.Shape.SCISSORS
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.be
import io.kotest.matchers.or
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.enum
import io.kotest.property.checkAll

class ShapeSpec : FunSpec({
    context("Shapes") {
        context("should win against each others according to the rules") {
            data class WinsAgainstTestCase(val challenger: Shape, val opponent: Shape, val expected: Boolean)
            withData(
                WinsAgainstTestCase(ROCK, ROCK, false),
                WinsAgainstTestCase(ROCK, PAPER, false),
                WinsAgainstTestCase(ROCK, SCISSORS, true),
                WinsAgainstTestCase(PAPER, ROCK, true),
                WinsAgainstTestCase(PAPER, PAPER, false),
                WinsAgainstTestCase(PAPER, SCISSORS, false),
                WinsAgainstTestCase(SCISSORS, ROCK, false),
                WinsAgainstTestCase(SCISSORS, PAPER, true),
                WinsAgainstTestCase(SCISSORS, SCISSORS, false)
            ) { (challenger, opponent, expected) ->
                challenger winsAgainst opponent shouldBe expected
            }
        }

        context("One picks a random shape") {
            test("He always picks the same shape if the set of choices only contains one shape") {
                checkAll(Arb.enum()) { singleShape: Shape ->
                    Shape.pickOneOf(singleShape) shouldBe singleShape
                }
            }

            test("He always picks a shape out of the set of choices and nothing else") {
                checkAll(Arb.enum(), Arb.enum()) { shapeOne: Shape, shapeTwo: Shape ->
                    Shape.pickOneOf(shapeOne, shapeTwo) should be(shapeOne).or(be(shapeTwo))
                }
            }
        }
    }
})