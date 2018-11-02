package de.merv.kata.rps

object Round {

    fun play(contender: Shape, opponent: Shape): Triple<Int, Int, Int> {
        if (contender == opponent) {
            return Triple(0, 1, 0)
        }

        TODO("Implement")
    }
}
