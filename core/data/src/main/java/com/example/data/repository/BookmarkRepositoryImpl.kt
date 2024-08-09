package com.example.data.repository

import com.example.data.mapper.BookmarkMapper.toEntity
import com.example.data.mapper.BookmarkMapper.toModel
import com.example.database.BookmarkDao
import com.example.domain.model.PhotosResponseEntity
import com.example.domain.repository.BookmarkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val bookmarkDao: BookmarkDao
) : BookmarkRepository {
    override suspend fun addBookmark(photosResponseEntity: PhotosResponseEntity) {
        return bookmarkDao.addBookmark(photosResponseEntity.toEntity())
    }

    override suspend fun deleteBookmark(photosResponseEntity: PhotosResponseEntity) {
        return bookmarkDao.deleteBookmark(photosResponseEntity.toEntity())
    }

    override fun getBookmarkPhoto(): Flow<List<PhotosResponseEntity>> {
        return bookmarkDao.getBookmarkPhoto()
            .map { bookmark ->
                bookmark.map {
                    it.toModel()
                }
            }
    }

    override fun isBookmarked(id: String): Flow<Boolean> {
        return bookmarkDao.isBookmarked(id)
    }
}