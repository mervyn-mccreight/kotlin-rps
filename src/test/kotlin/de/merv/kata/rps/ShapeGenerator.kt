package de.merv.kata.rps

import io.kotlintest.properties.Gen

class ShapeGenerator : Gen<Shape> {

    override fun constants(): Iterable<Shape> = enumValues<Shape>().toList()

    override fun random(): Sequence<Shape> = generateSequence {
        constants().shuffled().first()
    }
}
