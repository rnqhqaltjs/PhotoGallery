package com.example.data.di

import com.example.data.repository.BookmarkRepositoryImpl
import com.example.data.repository.PhotosRepositoryImpl
import com.example.domain.repository.BookmarkRepository
import com.example.domain.repository.PhotosRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Singleton
    @Binds
    fun bindPhotosRepository(
        photosRepositoryImpl: PhotosRepositoryImpl,
    ): PhotosRepository

    @Singleton
    @Binds
    fun bindBookmarkRepository(
        bookmarkRepositoryImpl: BookmarkRepositoryImpl,
    ): BookmarkRepository
}