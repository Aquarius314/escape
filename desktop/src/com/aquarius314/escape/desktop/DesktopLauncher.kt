package com.aquarius314.escape.desktop

import com.aquarius314.escape.main.GdxGame
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration

fun main(arg: Array<String>) {
    LwjglApplication(GdxGame(), LwjglApplicationConfiguration())
}
