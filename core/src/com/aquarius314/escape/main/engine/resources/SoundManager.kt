package com.aquarius314.escape.main.engine.resources

import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.Gdx



class SoundManager : ResourceManager<Sound>() {

    override fun loadAssets(files: List<String>) {
        for(soundFileName in files) {
            loadSound(soundFileName)
        }
    }

    private fun loadSound(fileName: String) {
        val sound = Gdx.audio.newSound(Gdx.files.internal("sound/$fileName"))
        assets[fileName] = sound
    }

    fun playSound(soundName: String) {
        playSound(soundName, 1.0f)
    }

    fun playSound(soundName: String, pitch: Float) {
        if (assets.containsKey(soundName)) {
            val sound = assets[soundName]
            val id = sound!!.play()
            sound.setPitch(id, pitch)
        } else {
            throw ResourceNotFoundException("File $soundName was not loaded!")
        }
    }

}