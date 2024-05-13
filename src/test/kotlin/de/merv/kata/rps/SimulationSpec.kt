package de.merv.kata.rps

import de.merv.kata.rps.Shape.Companion.pickOneOf
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.enum
import io.kotest.property.checkAll

class SimulationSpec : StringSpec() {
    init {
        "A simulation of two players always picking the same shape should result in 100-draws" {
            checkAll(Arb.enum()) { shape: Shape ->
                val playerOne: Player = { pickOneOf(shape) }
                val playerTwo: Player = { pickOneOf(shape) }

                Simulation.playGames(playerOne, playerTwo) shouldBe Triple(0, 100, 0)
            }
        }

        "A simulation should always result in 100 played rounds" {
            val randomPlayer = { pickOneOf(*Shape.entries.toTypedArray()) }
            val (win, draw, loss) = Simulation.playGames(randomPlayer, randomPlayer)

            win + draw + loss shouldBe 100
        }
    }
}
