package com.aquarius314.escape.main

import com.aquarius314.escape.main.engine.ui.GameInputProcessor
import com.badlogic.gdx.Gdx

class MainInputProcessor(var game: GdxGame) : GameInputProcessor() {

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        // invert for some strange reasons
        val x = screenX
        val y = Gdx.graphics.height - screenY
        game.player.tryShoot(x, y, button == 0)
        println("$x $y")
        return super.touchDown(screenX, screenY, pointer, button)
    }

}