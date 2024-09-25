package com.example.network.di

import com.example.network.remote.PhotoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ServiceModule {
    @Provides
    @Singleton
    fun providePhotoService(retrofit: Retrofit): PhotoService = retrofit.create(PhotoService::class.java)
}
