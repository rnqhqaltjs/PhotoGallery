package com.example.domain.repository

import com.example.model.Photo
import kotlinx.coroutines.flow.Flow

interface BookmarkRepository {
    suspend fun addBookmark(photo: Photo)

    suspend fun deleteBookmark(photo: Photo)

    fun getBookmarkPhoto(): Flow<List<Photo>>

    fun getBookmarkDetail(id: String): Flow<Photo>

    fun isBookmarked(id: String): Flow<Boolean>
}
