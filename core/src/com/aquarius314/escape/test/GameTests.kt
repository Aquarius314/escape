package com.aquarius314.escape.test

import com.aquarius314.escape.main.GdxGame
import com.badlogic.gdx.Gdx
import org.junit.Before
import org.junit.Test

class GameTests {

    var game = GdxGame()


    @Before
    fun setup() {
        game = GdxGame()
        game.create()
    }

    @Test
    fun testPlayerCreation() {
        val game = GdxGame()
        game.create()
        assert(game.player.x == 0)
        assert(game.player.y == 0)
    }

}
