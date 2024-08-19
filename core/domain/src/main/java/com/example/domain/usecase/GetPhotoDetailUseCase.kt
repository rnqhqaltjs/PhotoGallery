package com.example.domain.usecase

import com.example.domain.repository.PhotosRepository
import com.example.model.Photo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPhotoDetailUseCase @Inject constructor(
    private val photosRepository: PhotosRepository
) {
    operator fun invoke(id: String): Flow<Photo> =
        photosRepository.getPhotoDetail(id)
}