package com.aquarius314.escape.main.weapon

import com.aquarius314.escape.main.player.Player

class Pistol constructor(var player: Player, cap: Int = 60, reload: Int = 350) : Weapon(player, cap, reload) {

    val damage = 100

    override fun playShootingSound() {
        player.game!!.soundManager.playSound("pistol.mp3")
    }

}