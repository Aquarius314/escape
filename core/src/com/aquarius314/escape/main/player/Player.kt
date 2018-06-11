package com.aquarius314.escape.main.player

import com.aquarius314.escape.main.GdxGame
import com.aquarius314.escape.main.graphics.Displayable
import com.aquarius314.escape.main.graphics.Renderer
import com.aquarius314.escape.main.logic.Active
import com.aquarius314.escape.main.ui.KeyCodes
import com.badlogic.gdx.graphics.Color

class Player constructor(var x: Float = 0f, var y: Float = 0f) : Displayable, Active {

    var game: GdxGame? = null
    private val maxSpeed = 4f
    private var xSpeed = PlayerProperty(-maxSpeed, maxSpeed, 0f)
    private var ySpeed = PlayerProperty(-maxSpeed, maxSpeed, 0f)

    override fun display(renderer: Renderer) {
        renderer.circle(x, y, 30f, Color.BLACK)
    }

    override fun actions() {
        control()
    }

    private fun control() {
        val unitSpeed = 0.1f
        if (game!!.gameInputProcessor.isKeyPressed(KeyCodes.A.value)) {
            xSpeed.value -= unitSpeed
        }
        if (game!!.gameInputProcessor.isKeyPressed(KeyCodes.D.value)) {
            xSpeed.value += unitSpeed
        }
        if (game!!.gameInputProcessor.isKeyPressed(KeyCodes.W.value)) {
            ySpeed.value += unitSpeed
        }
        if (game!!.gameInputProcessor.isKeyPressed(KeyCodes.S.value)) {
            ySpeed.value -= unitSpeed
        }
        move(xSpeed.value, ySpeed.value)
    }

    fun move(x: Float, y: Float) {
        this.x += x
        this.y += y
    }

    fun moveTo(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

}