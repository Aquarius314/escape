package com.aquarius314.escape.main.graphics

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class Renderer(var spriteBatch: SpriteBatch, var shapeRenderer: ShapeRenderer) {

    fun renderBackground() {

    }

    constructor() : this(SpriteBatch(), ShapeRenderer())

}