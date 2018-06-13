package com.aquarius314.escape.main.player

import com.aquarius314.escape.main.GdxGame
import com.aquarius314.escape.main.engine.graphics.Renderer
import com.aquarius314.escape.main.engine.logic.Active
import com.aquarius314.escape.main.engine.logic.MeasurableProperty
import com.aquarius314.escape.main.engine.logic.Movable
import com.aquarius314.escape.main.weapon.Pistol
import com.aquarius314.escape.main.weapon.Shotgun
import com.badlogic.gdx.graphics.Color

class Player constructor(x: Float = 0f, y: Float = 0f) : Movable(x, y), Active {

    var weaponLeft = Pistol(this)
    var weaponRight = Shotgun(this)

    var game: GdxGame? = null
    var controller = PlayerController(this)

    override fun display(renderer: Renderer) {
        renderer.circle(x, y, colliderR, Color.BLACK)
    }

    override fun actions() {
        controller.control()
    }

    fun tryShoot(x: Int, y: Int, left: Boolean) {
        if (left) {
            if (weaponLeft.tryShoot()) {
                println("pistol shot")
            }
        } else {
            if (weaponRight.tryShoot()) {
                println("shotgun shot")
            }
        }
    }

}
