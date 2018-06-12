package com.aquarius314.escape.main.player

import com.aquarius314.escape.main.GdxGame
import com.aquarius314.escape.main.graphics.Renderer
import com.aquarius314.escape.main.logic.Active
import com.aquarius314.escape.main.logic.GameObject
import com.aquarius314.escape.main.logic.Movable
import com.badlogic.gdx.graphics.Color

class Player constructor(x: Float = 0f, y: Float = 0f) : Movable(x, y), Active {

    private val maxBullets = 4f

    var bullets = MeasurableProperty(0f, maxBullets)

    var game: GdxGame? = null
    var controller = PlayerController(this)

    override fun display(renderer: Renderer) {
        renderer.circle(x, y, colliderR, Color.BLACK)
    }

    override fun actions() {
        controller.control()
    }

}
