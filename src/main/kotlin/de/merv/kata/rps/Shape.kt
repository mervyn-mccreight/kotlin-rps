package de.merv.kata.rps

enum class Shape : ShapeInterface {
    ROCK,
    PAPER,
    SCISSORS,
    ;

    companion object {
        private val winnersMap = hashMapOf(
                ROCK to SCISSORS,
                PAPER to ROCK,
                SCISSORS to PAPER
        )
    }

    override fun winAgainst(opponent: Shape): Boolean {
        val possibleLoser = winnersMap[this]
        if (possibleLoser != null) {
            return possibleLoser == opponent
        }

        throw IllegalStateException("Shape is unknown to the rules")
    }
}

interface ShapeInterface {
    fun winAgainst(opponent: Shape): Boolean
}