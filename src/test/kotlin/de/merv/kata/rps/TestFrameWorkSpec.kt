package de.merv.kata.rps

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec

class TestFrameWorkSpec : BehaviorSpec({
    given("Kotlintest as a test framework") {
        `when`("I use it") {
            then("It works") {
                true shouldBe true
            }
        }
    }
})
