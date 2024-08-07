package com.example.domain.repository

import com.example.domain.model.PhotosResponseEntity
import kotlinx.coroutines.flow.Flow

interface BookmarkRepository {
    suspend fun addBookmark(photosResponseEntity: PhotosResponseEntity)
    suspend fun deleteBookmark(photosResponseEntity: PhotosResponseEntity)
    fun getBookmarkPhoto(): Flow<List<PhotosResponseEntity>>
}