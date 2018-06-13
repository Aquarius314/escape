package com.aquarius314.escape.main.weapon

import com.aquarius314.escape.main.player.Player

class Shotgun constructor(var player: Player, cap: Int = 20, reload: Int = 1000) : Weapon(player, cap, reload) {

    val damage = 30f
    val accuracy = 60f

    override fun playShootingSound() {
        player.game!!.soundManager.playSound("shotgun.mp3")
    }

    override fun createBullet(): List<Bullet> {
        return listOf(
                Bullet(player.x, player.y, damage, accuracy),
                Bullet(player.x, player.y, damage, accuracy),
                Bullet(player.x, player.y, damage, accuracy),
                Bullet(player.x, player.y, damage, accuracy),
                Bullet(player.x, player.y, damage, accuracy),
                Bullet(player.x, player.y, damage, accuracy)
        )
    }

}