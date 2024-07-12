package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.PhotosResponseEntity
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {
    fun getPhotosPaging(
        page: Int,
        perPage: Int
    ): Flow<PagingData<PhotosResponseEntity>>
}