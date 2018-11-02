package de.merv.kata.rps

import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class RoundSpec : StringSpec() {
    init {

        "A round with two equal shapes should always be evaluated as a draw" {

            assertAll(ShapeGenerator()) { shape ->
                Round.play(shape, shape) shouldBe Triple(0, 1, 0)
            }
        }
    }
}