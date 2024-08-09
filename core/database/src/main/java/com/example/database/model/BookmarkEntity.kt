package com.example.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
data class BookmarkEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @ColumnInfo(name = "create_at")
    val title: String?,
    val description: String?,
    @ColumnInfo(name = "user_name")
    val userName: String,
    val url: String
)
