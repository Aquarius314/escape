package com.aquarius314.escape.main.player

import com.aquarius314.escape.main.ui.KeyCodes

class PlayerController constructor(var player: Player){

    fun control() {
        chooseSpeed()
        player.move(player.xSpeed.value, player.ySpeed.value)
    }

    fun chooseSpeed() {
        player.xSpeed.value = 0f
        player.ySpeed.value = 0f
        val unitSpeed = 2f
        if (player.game!!.gameInputProcessor.isKeyPressed(KeyCodes.A.value)) {
            player.xSpeed.value = -unitSpeed
        }
        if (player.game!!.gameInputProcessor.isKeyPressed(KeyCodes.D.value)) {
            player.xSpeed.value = unitSpeed
        }
        if (player.game!!.gameInputProcessor.isKeyPressed(KeyCodes.W.value)) {
            player.ySpeed.value = unitSpeed
        }
        if (player.game!!.gameInputProcessor.isKeyPressed(KeyCodes.S.value)) {
            player.ySpeed.value = -unitSpeed
        }
        normalizeDiagonalSpeeds()
    }

    fun normalizeDiagonalSpeeds() {
        if (player.xSpeed.value * player.ySpeed.value != 0f) {
            player.xSpeed.value /= Math.sqrt(2.0).toFloat()
            player.ySpeed.value /= Math.sqrt(2.0).toFloat()
        }
    }

}