package com.example.database.di

import android.content.Context
import androidx.room.Room
import com.example.database.BookmarkDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun providesPromiseDatabase(
        @ApplicationContext context: Context,
    ): BookmarkDatabase =
        Room
            .databaseBuilder(
                context.applicationContext,
                BookmarkDatabase::class.java,
                "promise_database",
            ).build()

    @Singleton
    @Provides
    fun providesPromiseDao(bookmarkDatabase: BookmarkDatabase) = bookmarkDatabase.bookmarkDao()
}
