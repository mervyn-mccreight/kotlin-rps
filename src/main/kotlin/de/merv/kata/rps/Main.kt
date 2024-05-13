package de.merv.kata.rps

import de.merv.kata.rps.Shape.Companion.pickOneOf
import de.merv.kata.rps.Shape.ROCK
import de.merv.kata.rps.Simulation.playGames

fun main() {
    val rockPlayer: Player = { pickOneOf(ROCK) }
    val randomPlayer: Player = { pickOneOf(*Shape.entries.toTypedArray()) }

    val (win, draw, loss) = playGames(rockPlayer, randomPlayer)

    println("Rock player wins = $win")
    println("Random player wins = $loss")
    println("Draws = $draw")
}
