package com.aquarius314.escape.main.weapon

import com.aquarius314.escape.main.player.Player

class Pistol(var player: Player, cap: Int = 6, reload: Int = 500) : Weapon(player, cap, reload) {

    override fun playShootingSound() {
        player.game!!.soundManager.playSound("pistol.mp3")
    }

}