package com.aquarius314.escape.main.player

class PlayerProperty constructor(var min: Float, var max: Float, val initialValue: Float = min) {

    var value: Float = min
        set(value) {
            field = when {
                value > max -> max
                value < min -> min
                else -> value
            }
        }

    init {
        this.value = initialValue
    }

}