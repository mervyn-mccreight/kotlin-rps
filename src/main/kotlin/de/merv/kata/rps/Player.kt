package de.merv.kata.rps

object Player {
    fun playOneOf(vararg shapes: Shape): Shape = shapes.toSet().shuffled().first()
}
