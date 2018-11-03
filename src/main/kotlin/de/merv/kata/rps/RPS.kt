package de.merv.kata.rps

object RPS {

    @JvmStatic
    fun main(args : Array<String>) {
        val rockPlayer: Player = { Shape.pickOneOf(Shape.ROCK) }
        val randomPlayer: Player = { Shape.pickOneOf(*enumValues()) }

        val (win, draw, loss) = Simulation.playGames(rockPlayer, randomPlayer)

        println("Rock player wins = $win")
        println("Random player wins = $loss")
        println("Draws = $draw")
    }
}
