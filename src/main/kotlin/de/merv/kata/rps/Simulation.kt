package de.merv.kata.rps

import de.merv.kata.rps.Round.play

object Simulation {

    fun playGames(contender: Player, opponent: Player): Triple<Int, Int, Int> {
        val roundSequence = generateSequence {
            play(contender(), opponent())
        }

        return roundSequence.take(100).reduce { acc, triple ->
            Triple(acc.first + triple.first, acc.second + triple.second, acc.third + triple.third)
        }
    }
}
