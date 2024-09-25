package com.example.domain.repository

import androidx.paging.PagingData
import com.example.model.Photo
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {
    fun getPhotosPaging(): Flow<PagingData<Photo>>

    fun getPhotoDetail(id: String): Flow<Photo>

    fun getRandomPhoto(): Flow<PagingData<Photo>>
}
