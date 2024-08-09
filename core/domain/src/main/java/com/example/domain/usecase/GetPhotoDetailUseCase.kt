package com.example.domain.usecase

import com.example.domain.model.PhotosResponseEntity
import com.example.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPhotoDetailUseCase @Inject constructor(
    private val photosRepository: PhotosRepository
) {
    operator fun invoke(id: String): Flow<PhotosResponseEntity> =
        photosRepository.getPhotoDetail(id)
}