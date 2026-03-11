package com.reysl.videoapp.data.cache

import android.app.Application
import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.reysl.videoapp.constants.PlayerConstants
import com.reysl.videoapp.domain.model.VideoItem
import java.io.File

class VideoCacheManager(application: Application) {
    private val sharedPreferences =
        application.getSharedPreferences(
            PlayerConstants.PREF_NAME,
            Context.MODE_PRIVATE)
    private val gson = Gson()
    private val cacheDir: File = File(
        application.cacheDir,
        PlayerConstants.CACHE_DIR_NAME
    )

    fun saveVideo(videos: List<VideoItem>) {
        val json = gson.toJson(videos)
        sharedPreferences.edit {
            putString(PlayerConstants.CACHE_NAME, json)
        }
    }

    fun getVideos(): List<VideoItem> {
        val json = sharedPreferences.getString(PlayerConstants.CACHE_NAME, null)
        return if (json != null) {
            val type = object : TypeToken<List<VideoItem>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }

    fun isVideoCached(url: String): Boolean {
        val
                 fileName = url.substringAfterLast("/")
        return File(cacheDir, fileName).exists()
    }

    fun getCachedFile(url: String): File? {
        val fileName = url.substringAfterLast("/")
        val file = File(cacheDir, fileName)
        return if (file.exists()) file else null
    }
}