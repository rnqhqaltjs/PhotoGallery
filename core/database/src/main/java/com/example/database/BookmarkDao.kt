package com.example.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.model.BookmarkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBookmark(bookmarkEntity: BookmarkEntity)

    @Delete
    suspend fun deleteBookmark(bookmarkEntity: BookmarkEntity)

    @Query("SELECT * FROM bookmarks")
    fun getBookmarkPhoto(): Flow<List<BookmarkEntity>>

    @Query("SELECT * FROM bookmarks WHERE id = :id")
    fun getBookmarkDetail(id: String): Flow<BookmarkEntity>

    @Query("SELECT EXISTS(SELECT * FROM bookmarks WHERE id = :id)")
    fun isBookmarked(id: String): Flow<Boolean>
}