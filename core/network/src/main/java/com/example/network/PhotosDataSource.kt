package com.example.network

import com.example.network.remote.PhotoService
import javax.inject.Inject

class PhotosDataSource
    @Inject
    constructor(
        private val service: PhotoService,
    ) {
        suspend fun getPhotos(
            page: Int,
            perPage: Int,
        ) = service.getPhotos(page, perPage)

        suspend fun getPhotoDetail(id: String) = service.getPhotoDetail(id)

        suspend fun getRandomPhoto(count: Int) = service.getRandomPhoto(count)
    }
