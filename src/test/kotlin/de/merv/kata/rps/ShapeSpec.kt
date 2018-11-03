package de.merv.kata.rps

import io.kotlintest.be
import io.kotlintest.data.forall
import io.kotlintest.properties.assertAll
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec
import io.kotlintest.tables.row

class ShapeSpec : BehaviorSpec({

    given("Shapes") {
        `when`("They play against each other") {
            then("They should win according to the rules") {
                forall(
                        row(Shape.ROCK, Shape.ROCK, false),
                        row(Shape.ROCK, Shape.PAPER, false),
                        row(Shape.ROCK, Shape.SCISSORS, true),
                        row(Shape.PAPER, Shape.ROCK, true),
                        row(Shape.PAPER, Shape.PAPER, false),
                        row(Shape.PAPER, Shape.SCISSORS, false),
                        row(Shape.SCISSORS, Shape.ROCK, false),
                        row(Shape.SCISSORS, Shape.PAPER, true),
                        row(Shape.SCISSORS, Shape.SCISSORS, false)
                ) { shapeOne, shapeTwo, expected ->
                    shapeOne winsAgainst shapeTwo shouldBe expected
                }
            }
        }

        `when`("One picks a random shape") {
            then("He always picks the same shape if the set of choices only contains one shape") {
                assertAll(ShapeGenerator()) { singleShape: Shape ->
                    Shape.pickOneOf(singleShape) shouldBe singleShape
                }
            }

            then("He always picks a shape out of the set of choices and nothing else") {
                assertAll(ShapeGenerator(), ShapeGenerator()) { shapeOne: Shape, shapeTwo: Shape ->
                    Shape.pickOneOf(shapeOne, shapeTwo) should be(shapeOne).or(be(shapeTwo))
                }
            }
        }
    }
})