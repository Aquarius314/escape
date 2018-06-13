package com.aquarius314.escape.main.player

import com.aquarius314.escape.main.GdxGame
import com.aquarius314.escape.main.engine.graphics.Renderer
import com.aquarius314.escape.main.engine.logic.Active
import com.aquarius314.escape.main.engine.logic.Movable
import com.aquarius314.escape.main.weapon.Bullet
import com.aquarius314.escape.main.weapon.Pistol
import com.aquarius314.escape.main.weapon.Shotgun
import com.badlogic.gdx.graphics.Color
import java.util.*


class Player constructor(x: Float = 0f, y: Float = 0f) : Movable(x, y), Active {

    var weaponLeft = Pistol(this)
    var weaponRight = Shotgun(this)

    var game: GdxGame? = null
    var controller = PlayerController(this)

    var bullets = arrayListOf<Bullet>()

    override fun display(renderer: Renderer) {
        renderer.circle(x, y, colliderR, Color.BLACK)
        bullets.forEach { b -> b.display(renderer) }
    }

    override fun actions() {
        controller.control()
        bullets.forEach { b -> b.actions() }
    }

    fun tryShoot(x: Int, y: Int, left: Boolean) {
        var newBullets = listOf<Bullet>()
        if (left) {
            if (weaponLeft.tryShoot()) {
                newBullets = weaponLeft.createBullet()
            }
        } else {
            if (weaponRight.tryShoot()) {
                newBullets = weaponRight.createBullet()
            }
        }
        newBullets.forEach { b -> setBulletSpeeds(b, x.toFloat(), y.toFloat())}
        bullets.addAll(newBullets)
    }

    fun setBulletSpeeds(bullet: Bullet, targetX: Float, targetY: Float) {

        val rTargetX = targetX + Random().nextInt()%bullet.accuracy - bullet.accuracy/2
        val rTargetY = targetY + Random().nextInt()%bullet.accuracy - bullet.accuracy/2

        val deltaX = rTargetX - x //this code is when I create a new bullet
        val deltaY = rTargetY - y
        val radius = Math.sqrt((deltaX * deltaX + deltaY * deltaY).toDouble())
        val normalizedDeltaX = deltaX / radius
        val normalizedDeltaY = deltaY / radius
        val speed = 100f

        val vx = speed * normalizedDeltaX
        val vy = speed * normalizedDeltaY

        bullet.setSpeeds(vx.toFloat(), vy.toFloat())
    }

}
