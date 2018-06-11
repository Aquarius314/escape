package com.aquarius314.escape.test

import com.aquarius314.escape.main.player.PlayerProperty
import org.junit.Test

class PlayerPropertyTests {

    @Test
    fun testPlayerProperty() {
        val min = -100f
        val max = 100f
        val value = 43f
        val property = PlayerProperty(min, max)
        property.value = value
        assert(property.value == value)
        property.value += 20
        assert(property.value == value + 20)
        property.value = max + 30
        assert(property.value == max)
        property.value = min - 30
        assert(property.value == min)
    }

}