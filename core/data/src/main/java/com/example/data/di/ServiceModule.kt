package com.example.data.di

import com.example.data.remote.PhotoService
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
    fun providePhotoService(retrofit: Retrofit): PhotoService {
        return retrofit.create(PhotoService::class.java)
    }
}