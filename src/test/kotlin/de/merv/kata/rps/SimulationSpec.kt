package de.merv.kata.rps

import de.infix.testBalloon.framework.testSuite
import de.merv.kata.rps.Shape.Companion.pickOneOf

val SimulationSpec by testSuite {
    test("A simulation of two players always picking the same shape should result in 100-draws") {
        Shape
            .entries
            .forEach { shape ->
                val playerOne: Player = { pickOneOf(shape) }
                val playerTwo: Player = { pickOneOf(shape) }

                assert(Simulation.playGames(playerOne, playerTwo) == Triple(0, 100, 0))
            }
    }

    test("A simulation should always result in 100 played rounds") {
        val randomPlayer = { pickOneOf(*Shape.entries.toTypedArray()) }
        val (win, draw, loss) = Simulation.playGames(randomPlayer, randomPlayer)

        assert((win + draw + loss) == 100)
    }
}
