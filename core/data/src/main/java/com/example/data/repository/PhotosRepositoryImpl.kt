package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.paging.PhotosPagingSource
import com.example.data.source.PhotosDataSource
import com.example.domain.model.PhotosResponseEntity
import com.example.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val photosDataSource: PhotosDataSource
) : PhotosRepository {
    override fun getPhotosPaging(
        page: Int,
        perPage: Int
    ): Flow<PagingData<PhotosResponseEntity>> {
        val pagingSourceFactory = { PhotosPagingSource(photosDataSource) }

        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                maxSize = 10 * 3
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}