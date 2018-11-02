package de.merv.kata.rps

import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class SimulationSpec : StringSpec() {
    init {
        "A simulation of two players always picking the same shape should result in 100-draws" {
            assertAll(ShapeGenerator()) { shape: Shape ->
                val playerOne = { Player.playOneOf(shape) }
                val playerTwo = { Player.playOneOf(shape) }

                Simulation.playGames(playerOne, playerTwo) shouldBe Triple(0, 100, 0)
            }
        }

        "A simulation should always result in 100 played rounds" {
            val randomPlayer = { Player.playOneOf(*enumValues()) }
            val (win, draw, loss) = Simulation.playGames(randomPlayer, randomPlayer)

            win + draw + loss shouldBe 100
        }
    }
}