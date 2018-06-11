package com.aquarius314.escape.test

import com.aquarius314.escape.main.player.Player
import org.junit.Before
import org.junit.Test

class PlayerTests {

    private var player: Player = setupPlayer()
    private val x = 111f
    private val y = 222f

    @Before
    fun setup() {
        player = setupPlayer()
    }

    private fun setupPlayer() : Player = Player(x, y)

    @Test
    fun testPlayerPosition() {
        assert(player.x == x && player.y == y)
        fun testCoordinate(getter: () -> Float, setter: (_: Float) -> Unit) {
            val newCoordinate = getter() + 1
            setter(newCoordinate)
            assert(getter() == newCoordinate)
        }
        testCoordinate({player.x}, {v -> player.x = v})
        testCoordinate({player.y}, {v -> player.y = v})
    }

    @Test
    fun testPlayerMove() {
        val oldX = player.x
        val oldY = player.y
        val x = 2f
        val y = 4f
        player.move(x, y)
        assert(player.x == oldX + x && player.y == oldY + y)
    }

    @Test
    fun testPlayerMoveTo() {
        val x = 123f
        val y = 234f
        player.moveTo(x, y)
        assert(player.x == x && player.y == y)
    }



}

