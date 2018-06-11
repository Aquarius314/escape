package com.aquarius314.escape.main

import com.aquarius314.escape.main.graphics.Renderer
import com.aquarius314.escape.main.player.Player
import com.aquarius314.escape.main.ui.GameInputProcessor
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx

class GdxGame : ApplicationAdapter() {

    var renderer: Renderer? = null
    var player = Player()
    val gameInputProcessor = GameInputProcessor(this)

    override fun create() {
        renderer = Renderer()
        player.game = this
        player.moveTo(Gdx.graphics.width/2f, Gdx.graphics.height/2f)

        Gdx.input.inputProcessor = gameInputProcessor
    }

    override fun render() {
        renderer?.renderBackground()
        calculate()
        player.display(renderer!!)
    }

    fun calculate() {
        player.actions()
    }

    override fun dispose() {

    }
}