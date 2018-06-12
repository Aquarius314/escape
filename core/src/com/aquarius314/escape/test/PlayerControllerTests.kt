package com.aquarius314.escape.test

import com.aquarius314.escape.main.player.Player
import com.aquarius314.escape.main.player.PlayerController
import org.junit.Before
import org.junit.Test

class PlayerControllerTests {

    private var controller = createFreshPlayerController()

    @Before
    fun setup() {
        controller = createFreshPlayerController()
    }

    private fun createFreshPlayerController() : PlayerController {
        val player = Player()
        return PlayerController(player)
    }

    @Test
    fun testShorterDiagonalSpeeds() {
        // speeds should get shorter when diagonal
        controller.player.xSpeed.value = 2f
        controller.player.ySpeed.value = -2f
        controller.normalizeDiagonalSpeeds()
        assert(controller.player.xSpeed.value == Math.sqrt(2.0).toFloat())
        assert(controller.player.ySpeed.value == -Math.sqrt(2.0).toFloat())

        // speeds should stay the same when not diagonal
        controller.player.xSpeed.value = -2f
        controller.player.ySpeed.value = 0f
        controller.normalizeDiagonalSpeeds()
        assert(controller.player.xSpeed.value == -2f)
        assert(controller.player.ySpeed.value == 0f)
    }

}