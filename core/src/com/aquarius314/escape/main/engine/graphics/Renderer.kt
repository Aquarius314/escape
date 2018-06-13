package com.aquarius314.escape.main.engine.graphics

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2



class Renderer(var shapeRenderer: ShapeRenderer = ShapeRenderer(),
               var spriteBatch: SpriteBatch = SpriteBatch()) {

    fun renderBackground() {
        Gdx.gl.glClearColor(0.2f, 0.7f, 0.2f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    fun circle(x: Float, y: Float, r: Float, color: Color) {
        renderShape {
            shapeRenderer.color = color
            shapeRenderer.circle(x, y, r)
        }
    }

    fun line(x1: Float, y1: Float, x2: Float, y2: Float, color: Color) {
        renderShape { shapeRenderer.rectLine(Vector2(x1, y1), Vector2(x2, y2), 4f) }
    }

    fun renderShape(action: () -> Unit) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        action()
        shapeRenderer.end()
    }

}