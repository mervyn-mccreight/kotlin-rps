package de.merv.kata.rps

import io.kotlintest.be
import io.kotlintest.properties.assertAll
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class PlayerSpec : StringSpec() {

    init {
        "A player with only one choice should always play exactly this choice" {
            assertAll(ShapeGenerator()) { singleShape: Shape ->
                Player.playOneOf(singleShape) shouldBe singleShape
            }
        }

        "A player with more choices should always play one of the given choices" {
            assertAll(ShapeGenerator(), ShapeGenerator()) { shapeOne: Shape, shapeTwo: Shape ->
                Player.playOneOf(shapeOne, shapeTwo) should be(shapeOne).or(be(shapeTwo))
            }
        }
    }
}
