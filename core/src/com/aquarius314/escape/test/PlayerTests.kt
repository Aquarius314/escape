package com.aquarius314.escape.test

import com.aquarius314.escape.main.player.Player
import org.junit.Before
import org.junit.Test

class PlayerTests {

    private var player: Player = setupPlayer()
    private val x: Int = 111
    private val y: Int = 222

    @Before
    fun setup() {
        player = setupPlayer()
    }

    private fun setupPlayer() : Player = Player(x, y)

    @Test
    fun testPlayerPosition() {
        assert(player.x == x)
        assert(player.y == y)
        testCoordinate({player.x}, {v -> player.x = v})
        testCoordinate({player.y}, {v -> player.y = v})
    }

    private fun testCoordinate(getter: () -> Int, setter: (_: Int) -> Unit) {
        val newCoordinate = getter() + 1
        setter(newCoordinate)
        assert(getter() == newCoordinate)
    }

}

