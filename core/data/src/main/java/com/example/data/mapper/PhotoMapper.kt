package com.example.data.mapper

import com.example.domain.model.PhotosResponseEntity
import com.example.network.model.ResponsePhotosDto

object PhotoMapper {
    fun ResponsePhotosDto.toEntity(): PhotosResponseEntity {
        return PhotosResponseEntity(
            id = this.id,
            title = this.altDescription,
            description = this.description,
            userName = this.user.name,
            url = this.urls.regular
        )
    }
}