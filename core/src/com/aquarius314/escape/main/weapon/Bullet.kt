package com.aquarius314.escape.main.weapon

import com.aquarius314.escape.main.engine.graphics.Renderer
import com.aquarius314.escape.main.engine.logic.Active
import com.aquarius314.escape.main.engine.logic.Movable
import com.badlogic.gdx.graphics.Color

class Bullet constructor(x: Float, y: Float, var dmg: Float, var accuracy: Float) : Movable(x, y), Active {

    var previousX = x
    var previousY = y

    override fun move(x: Float, y: Float) {
        previousX = this.x
        previousY = this.y
        super.move(x, y)
    }

    fun setSpeeds(vx: Float, vy: Float) {
        xSpeed.max = vx
        ySpeed.max = vy
        xSpeed.min = vx
        ySpeed.min = vy
        xSpeed.value = vx
        ySpeed.value = vy
    }

    override fun display(renderer: Renderer) {
        renderer.circle(x, y, 3f, Color.GRAY)
        renderer.line(x, y, previousX, previousY, Color.GRAY)
    }

    override fun actions() {
        move(xSpeed.value, ySpeed.value)
    }

}