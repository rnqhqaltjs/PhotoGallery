package com.example.data.mapper

import com.example.domain.model.PhotosResponseEntity
import com.example.network.model.ResponsePhotosDto

object PhotoMapper {
    fun ResponsePhotosDto.toEntity(): PhotosResponseEntity {
        return PhotosResponseEntity(
            id = this.id,
            createdAt = this.createdAt,
            description = this.description,
            url = this.urls.regular
        )
    }
}