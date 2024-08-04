package com.example.data.source

import com.example.data.remote.PhotoService
import javax.inject.Inject

class PhotosDataSource @Inject constructor(
    private val service: PhotoService
) {
    suspend fun getPhotos(page: Int, perPage: Int) =
        service.getPhotos(page, perPage)

    suspend fun getRandomPhoto(count: Int) =
        service.getRandomPhoto(count)
}