package de.merv.kata.rps

enum class Shape {
    ROCK,
    PAPER,
    SCISSORS;

    private val beats: Shape by lazy {
        when (this) {
            ROCK -> SCISSORS
            PAPER -> ROCK
            SCISSORS -> PAPER
        }
    }

    infix fun winsAgainst(opponent: Shape): Boolean =
        this.beats == opponent

    companion object {
        fun pickOneOf(vararg shapes: Shape): Shape = shapes.toSet().shuffled().first()
    }
}
