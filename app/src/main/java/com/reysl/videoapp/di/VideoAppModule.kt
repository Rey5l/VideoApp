@file:Suppress("DEPRECATION")

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
import com.reysl.videoapp.data.api.VideoApi
import com.reysl.videoapp.data.cache.VideoCacheManager
import com.reysl.videoapp.data.repository.VideoRepositoryImpl
import com.reysl.videoapp.domain.repository.VideoRepository
import com.reysl.videoapp.domain.usecases.GetVideos
import com.reysl.videoapp.domain.usecases.VideoUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VideoAppModule {

    @Provides
    @Singleton
    fun providesVideoApi(): VideoApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(PlayerConstants.BASE_URL)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providesVideoRepository(
        videoApi: VideoApi,
        application: Application
    ): VideoRepository {
        return VideoRepositoryImpl(videoApi = videoApi, application = application)
    }


    @Provides
    @Singleton
    fun providesVideoUseCases(
        videoRepository: VideoRepository
    ): VideoUseCases {
        return VideoUseCases(
            getVideos = GetVideos(videoRepository = videoRepository)
        )
    }


}