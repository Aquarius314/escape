package com.aquarius314.escape.test

import com.aquarius314.escape.main.player.Player
import com.aquarius314.escape.main.weapon.Bullet
import com.aquarius314.escape.main.weapon.Weapon
import org.junit.Test

class WeaponTests {

    private class WeaponImplementation constructor(p: Player, c: Int, r: Int): Weapon(p, c, r) {
        override fun createBullet(): List<Bullet> = listOf()
        override fun playShootingSound() {}
    }

    val player = Player()
    val reloadTime = 200

    @Test
    fun testWeaponReload() {
        val weapon = WeaponImplementation(player, 12, reloadTime)
        Thread.sleep(reloadTime.toLong() + 100)
        val ammunition = weapon.ammunition
        assert(weapon.canShoot())
        weapon.tryShoot()
        assert(weapon.ammunition == ammunition - 1) // should be one bullet less
        weapon.tryShoot()
        assert(weapon.ammunition == ammunition - 1) // should still be only one bullet less
        assert(!weapon.canShoot())
        Thread.sleep(reloadTime.toLong() + 100)
        assert(weapon.canShoot())
        weapon.tryShoot()
        assert(weapon.ammunition == ammunition - 2) // after 1 second, shooting possible, so should be another bullet less
    }

    @Test
    fun testWeaponCapacity() {
        val weapon = WeaponImplementation(player, 2, 1)
        Thread.sleep(reloadTime.toLong() + 50)
        weapon.tryShoot()
        Thread.sleep(reloadTime.toLong() + 50)
        assert(!weapon.isEmpty())
        weapon.tryShoot()
        assert(weapon.isEmpty())
    }

}