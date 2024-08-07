package com.example.data.mapper

import com.example.database.model.BookmarkEntity
import com.example.domain.model.PhotosResponseEntity

object BookmarkMapper {
    fun BookmarkEntity.toModel(): PhotosResponseEntity {
        return PhotosResponseEntity(
            id = this.id,
            createdAt = this.createdAt,
            description = this.description,
            url = this.url
        )
    }

    fun PhotosResponseEntity.toEntity(): BookmarkEntity {
        return BookmarkEntity(
            id = this.id,
            createdAt = this.createdAt,
            description = this.description,
            url = this.url
        )
    }
}