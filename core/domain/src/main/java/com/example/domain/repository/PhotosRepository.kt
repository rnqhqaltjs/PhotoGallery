package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.PhotosResponseEntity
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {
    fun getPhotosPaging(): Flow<PagingData<PhotosResponseEntity>>
    fun getPhotoDetail(id: String): Flow<PhotosResponseEntity>
    fun getRandomPhoto(): Flow<PagingData<PhotosResponseEntity>>
}