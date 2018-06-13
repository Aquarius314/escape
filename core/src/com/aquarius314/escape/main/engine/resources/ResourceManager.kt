package com.aquarius314.escape.main.engine.resources

import com.badlogic.gdx.utils.Disposable


abstract class ResourceManager<T : Disposable> {

    protected val assets: HashMap<String, T> = HashMap()

    abstract fun loadAssets(files: List<String>)

    fun get(filePath: String): T {
        return if (assets.containsKey(filePath)) {
            assets[filePath]!!
        } else {
            throw ResourceNotFoundException("Could not load resource: $filePath")
        }
    }

    fun dispose() {
        for (d in assets.values) {
            d.dispose()
        }
    }

}