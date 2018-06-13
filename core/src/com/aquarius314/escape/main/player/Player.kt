package com.aquarius314.escape.main.player

import com.aquarius314.escape.main.GdxGame
import com.aquarius314.escape.main.engine.graphics.Renderer
import com.aquarius314.escape.main.engine.logic.Active
import com.aquarius314.escape.main.engine.logic.MeasurableProperty
import com.aquarius314.escape.main.engine.logic.Movable
import com.aquarius314.escape.main.weapon.Pistol
import com.badlogic.gdx.graphics.Color

class Player constructor(x: Float = 0f, y: Float = 0f) : Movable(x, y), Active {

    var weapon = Pistol(this)

    var game: GdxGame? = null
    var controller = PlayerController(this)

    override fun display(renderer: Renderer) {
        renderer.circle(x, y, colliderR, Color.BLACK)
    }

    override fun actions() {
        controller.control()
    }

    fun tryShoot(x: Int, y: Int) {
        if (weapon.tryShoot()) {
            println("hehe")
        }
    }

}
