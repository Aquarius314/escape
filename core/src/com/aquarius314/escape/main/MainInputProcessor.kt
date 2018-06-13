package com.aquarius314.escape.main

import com.aquarius314.escape.main.engine.ui.GameInputProcessor

class MainInputProcessor(var game: GdxGame) : GameInputProcessor() {

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        game.player.tryShoot(screenX, screenY, button == 0)
        return super.touchDown(screenX, screenY, pointer, button)
    }

}