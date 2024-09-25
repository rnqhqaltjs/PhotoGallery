package com.example.data.mapper

import com.example.database.model.BookmarkEntity
import com.example.model.Photo

object BookmarkMapper {
    fun BookmarkEntity.toModel(): Photo =
        Photo(
            id = this.id,
            title = this.title,
            description = this.description,
            userName = this.userName,
            url = this.url,
        )

    fun Photo.toEntity(): BookmarkEntity =
        BookmarkEntity(
            id = this.id,
            title = this.title,
            description = this.description,
            userName = this.userName,
            url = this.url,
        )
}
