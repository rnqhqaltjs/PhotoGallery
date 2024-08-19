package com.example.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {
    fun getPhotosPaging(): Flow<PagingData<com.example.model.Photo>>
    fun getPhotoDetail(id: String): Flow<com.example.model.Photo>
    fun getRandomPhoto(): Flow<PagingData<com.example.model.Photo>>
}