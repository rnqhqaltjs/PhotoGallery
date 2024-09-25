package com.example.data.mapper

import com.example.model.Photo
import com.example.network.model.PhotoResponse

object PhotoMapper {
    fun PhotoResponse.toModel(): Photo =
        Photo(
            id = this.id,
            title = this.altDescription,
            description = this.description,
            userName = this.user.name,
            url = this.urls.regular,
        )
}
