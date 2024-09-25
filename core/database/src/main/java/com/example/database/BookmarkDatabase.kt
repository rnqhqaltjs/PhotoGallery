package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.model.BookmarkEntity

@Database(
    entities = [BookmarkEntity::class],
    version = 1,
    exportSchema = false,
)
// @TypeConverters(
//    value = [
//        UserInfoTypeConverter::class,
//        TimeInfoTypeConverter::class,
//        PlaceInfoTypeConverter::class
//    ]
// )
abstract class BookmarkDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
}
