package com.aquarius314.escape.main

import com.aquarius314.escape.main.engine.graphics.Renderer
import com.aquarius314.escape.main.engine.resources.SoundManager
import com.aquarius314.escape.main.player.Player
import com.aquarius314.escape.main.engine.ui.GameInputProcessor
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx

class GdxGame : ApplicationAdapter() {

    var renderer: Renderer? = null
    var player = Player()
    val inputProcessor = MainInputProcessor(this)
    val soundManager = SoundManager()

    override fun create() {
        soundManager.loadAssets(ResourcesLoader.soundFiles)
        renderer = Renderer()
        player.game = this
        player.moveTo(Gdx.graphics.width/2f, Gdx.graphics.height/2f)

        Gdx.input.inputProcessor = inputProcessor
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