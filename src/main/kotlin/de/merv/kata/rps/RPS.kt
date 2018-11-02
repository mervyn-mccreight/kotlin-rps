package de.merv.kata.rps

object RPS {

    @JvmStatic
    fun main(args : Array<String>) {
        val rockPlayer = {Player.playOneOf(Shape.ROCK)}
        val randomPlayer = {Player.playOneOf(*enumValues())}
        val (win, draw, loss) = Simulation.playGames(rockPlayer, randomPlayer)

        println("Rock player wins = $win")
        println("Random player wins = $loss")
        println("Draws = $draw")
    }
}

