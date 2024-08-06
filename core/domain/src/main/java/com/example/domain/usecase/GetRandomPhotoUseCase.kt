package com.example.domain.usecase

import androidx.paging.PagingData
import com.example.domain.model.PhotosResponseEntity
import com.example.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRandomPhotoUseCase @Inject constructor(
    private val photosRepository: PhotosRepository
) {
    operator fun invoke(): Flow<PagingData<PhotosResponseEntity>> =
        photosRepository.getRandomPhoto()
}