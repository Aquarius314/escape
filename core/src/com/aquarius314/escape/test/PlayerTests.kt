package com.aquarius314.escape.test

import com.aquarius314.escape.main.player.Player
import org.junit.Before
import org.junit.Test


class PlayerTests {

    var player: Player = setupPlayer()
    val x: Int = 111
    val y: Int = 222

    @Before
    fun setup() {
        player = setupPlayer()
    }

    fun setupPlayer() : Player = Player(x, y)

    @Test
    fun testPlayerPosition() {
        assert(player.x == x)
        assert(player.y == y)
    }

}