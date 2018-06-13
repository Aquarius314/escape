package com.aquarius314.escape.main.weapon

import com.aquarius314.escape.main.engine.logic.MeasurableProperty
import com.aquarius314.escape.main.player.Player

abstract class Weapon constructor(var owner: Player, capacity: Int, var reloadTime: Int) {

    protected var bullets = MeasurableProperty(0f, capacity.toFloat(), capacity.toFloat())
    protected var lastShotTime = 0L

    var ammunition = bullets.value
        get() {
            return bullets.value
        }

    fun isReady() : Boolean = System.currentTimeMillis() - lastShotTime > reloadTime

    fun isEmpty() : Boolean = bullets.value <= 0

    fun canShoot() : Boolean = isReady() && !isEmpty()

    fun tryShoot() : Boolean {
        if (canShoot()) {
            bullets.value -= 1
            lastShotTime = System.currentTimeMillis()
            playShootingSound()
            return true
        }
        return false
    }

    abstract fun playShootingSound()

    abstract fun createBullet() : List<Bullet>

}