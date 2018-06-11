package com.aquarius314.escape.main

import com.aquarius314.escape.main.graphics.Renderer
import com.aquarius314.escape.main.player.Player
import com.badlogic.gdx.ApplicationAdapter

open class GdxGame : ApplicationAdapter() {

    var player = Player()
    var renderer = Renderer()

    override fun create() {

    }

    override fun render() {
        renderer.renderBackground()
    }

    override fun dispose() {

    }
}