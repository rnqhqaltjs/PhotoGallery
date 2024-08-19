package com.example.domain.usecase

import androidx.paging.PagingData
import com.example.domain.repository.PhotosRepository
import com.example.model.Photo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRandomPhotoUseCase @Inject constructor(
    private val photosRepository: PhotosRepository
) {
    operator fun invoke(): Flow<PagingData<Photo>> =
        photosRepository.getRandomPhoto()
}