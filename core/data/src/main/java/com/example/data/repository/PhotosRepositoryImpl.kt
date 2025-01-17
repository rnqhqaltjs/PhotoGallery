package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.mapper.PhotoMapper.toModel
import com.example.data.paging.PhotosPagingSource
import com.example.data.paging.RandomPhotoPagingSource
import com.example.domain.repository.PhotosRepository
import com.example.model.Photo
import com.example.network.PhotosDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PhotosRepositoryImpl
    @Inject
    constructor(
        private val photosDataSource: PhotosDataSource,
    ) : PhotosRepository {
        override fun getPhotosPaging(): Flow<PagingData<Photo>> {
            val pagingSourceFactory = { PhotosPagingSource(photosDataSource) }

            return Pager(
                config =
                    PagingConfig(
                        pageSize = 10,
                        enablePlaceholders = false,
                    ),
                pagingSourceFactory = pagingSourceFactory,
            ).flow
        }

        override fun getPhotoDetail(id: String): Flow<Photo> =
            flow {
                val result = photosDataSource.getPhotoDetail(id)
                emit(result.toModel())
            }

        override fun getRandomPhoto(): Flow<PagingData<Photo>> {
            val pagingSourceFactory = { RandomPhotoPagingSource(photosDataSource) }

            return Pager(
                config =
                    PagingConfig(
                        pageSize = 5,
                        enablePlaceholders = false,
                    ),
                pagingSourceFactory = pagingSourceFactory,
            ).flow
        }
    }
