package com.aquarius314.escape.main.engine.graphics

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class Renderer(var shapeRenderer: ShapeRenderer = ShapeRenderer(),
               var spriteBatch: SpriteBatch = SpriteBatch()) {

    fun renderBackground() {
        Gdx.gl.glClearColor(0.2f, 0.7f, 0.2f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    fun circle(x: Float, y: Float, r: Float, color: Color) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        shapeRenderer.color = color
        shapeRenderer.circle(x, y, r)
        shapeRenderer.end()
    }

}