package com.reysl.videoapp.di

import android.app.Application
import androidx.annotation.OptIn
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.cache.CacheDataSource
import androidx.media3.datasource.cache.NoOpCacheEvictor
import androidx.media3.datasource.cache.SimpleCache
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import com.reysl.videoapp.constants.PlayerConstants
import com.reysl.videoapp.data.cache.VideoCacheManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object VideoCacheModule {


    @OptIn(UnstableApi::class)
    @Provides
    @Singleton
    fun provideVideoPlayer(app: Application): Player {
        val cacheDir = File(app.cacheDir, PlayerConstants.CACHE_DIR_NAME)
        val cache = SimpleCache(cacheDir, NoOpCacheEvictor())

        val cacheDataSourceFactory = CacheDataSource.Factory()
            .setCache(cache)
            .setUpstreamDataSourceFactory(DefaultDataSource.Factory(app))

        val mediaSourceFactory = ProgressiveMediaSource.Factory(cacheDataSourceFactory)

        return ExoPlayer.Builder(app)
            .setMediaSourceFactory(mediaSourceFactory)
            .build()
    }


    @Provides
    @Singleton
    fun providesVideoCacheManager(application: Application): VideoCacheManager {
        return VideoCacheManager(application)
    }
}