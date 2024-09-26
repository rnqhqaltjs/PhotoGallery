package com.example.data.di

import android.content.Context
import com.example.data.repository.BookmarkRepositoryImpl
import com.example.data.repository.DownloadRepositoryImpl
import com.example.data.repository.PhotosRepositoryImpl
import com.example.domain.repository.BookmarkRepository
import com.example.domain.repository.DownloadRepository
import com.example.domain.repository.PhotosRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Singleton
    @Binds
    fun bindPhotosRepository(photosRepositoryImpl: PhotosRepositoryImpl): PhotosRepository

    @Singleton
    @Binds
    fun bindBookmarkRepository(bookmarkRepositoryImpl: BookmarkRepositoryImpl): BookmarkRepository

    @Singleton
    @Binds
    fun bindDownloadRepository(downloadRepositoryImpl: DownloadRepositoryImpl): DownloadRepository
}

@Module
@InstallIn(SingletonComponent::class)
object ContextModule {
    @Provides
    @Singleton
    fun provideApplicationContext(
        @ApplicationContext context: Context,
    ): Context = context
}
