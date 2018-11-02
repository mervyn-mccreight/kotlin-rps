package de.merv.kata.rps

object Round {

    private val DRAW = Triple(0, 1, 0)
    private val WIN = Triple(1, 0, 0)
    private val LOSE = Triple(0, 0, 1)

    fun play(contender: Shape, opponent: Shape): Triple<Int, Int, Int> {
        if (contender == opponent) {
            return DRAW
        }

        return if (contender winsAgainst opponent) WIN else LOSE
    }
}
