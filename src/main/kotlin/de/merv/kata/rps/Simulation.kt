package de.merv.kata.rps

object Simulation {

    fun playGames(contender: () -> Shape, opponent: () -> Shape): Triple<Int, Int, Int> {
        val roundSequence = generateSequence {
            Round.play(contender(), opponent())
        }

        return roundSequence.take(100).reduce { acc, triple ->
            Triple(acc.first + triple.first, acc.second + triple.second, acc.third + triple.third)
        }
    }
}
