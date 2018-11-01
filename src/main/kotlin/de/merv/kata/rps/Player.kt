package de.merv.kata.rps

class Player {

    fun playOneOf(vararg shapes: Shape): Shape = shapes.toSet().shuffled().first()
}
