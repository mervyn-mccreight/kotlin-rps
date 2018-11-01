package de.merv.kata.rps

import io.kotlintest.data.forall
import io.kotlintest.matchers.collections.containExactlyInAnyOrder
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec
import io.kotlintest.tables.row

class ShapeSpec : BehaviorSpec({

    given("Shapes") {
        `when`("I gather all existing shapes") {
            then("Exactly Rock, Paper and Scissors should exist") {
                enumValues<Shape>().toList() should containExactlyInAnyOrder(Shape.ROCK, Shape.PAPER, Shape.SCISSORS)
            }
        }

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
    }
})