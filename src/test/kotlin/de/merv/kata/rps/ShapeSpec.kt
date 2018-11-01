package de.merv.kata.rps

import io.kotlintest.matchers.collections.containExactlyInAnyOrder
import io.kotlintest.should
import io.kotlintest.specs.BehaviorSpec

class ShapeSpec : BehaviorSpec({

    given("Shapes") {
        `when`("I gather all existing shapes") {
            then("Exactly Rock, Paper and Scissors should exist") {
                enumValues<Shape>().toList() should containExactlyInAnyOrder(Shape.ROCK, Shape.PAPER, Shape.SCISSORS)
            }
        }
    }
})