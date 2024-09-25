package com.example.data.repository

import com.example.data.mapper.BookmarkMapper.toEntity
import com.example.data.mapper.BookmarkMapper.toModel
import com.example.database.BookmarkDao
import com.example.domain.repository.BookmarkRepository
import com.example.model.Photo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BookmarkRepositoryImpl
    @Inject
    constructor(
        private val bookmarkDao: BookmarkDao,
    ) : BookmarkRepository {
        override suspend fun addBookmark(photo: Photo) = bookmarkDao.addBookmark(photo.toEntity())

        override suspend fun deleteBookmark(photo: Photo) = bookmarkDao.deleteBookmark(photo.toEntity())

        override fun getBookmarkPhoto(): Flow<List<Photo>> =
            bookmarkDao
                .getBookmarkPhoto()
                .map { bookmark ->
                    bookmark.map {
                        it.toModel()
                    }
                }

        override fun getBookmarkDetail(id: String): Flow<Photo> =
            bookmarkDao
                .getBookmarkDetail(id)
                .map {
                    it.toModel()
                }

        override fun isBookmarked(id: String): Flow<Boolean> = bookmarkDao.isBookmarked(id)
    }
