package com.example.domain.usecase

import com.example.domain.repository.DownloadRepository
import javax.inject.Inject

class DownloadPhotoUseCase
    @Inject
    constructor(
        private val downloadRepository: DownloadRepository,
    ) {
        operator fun invoke(photoUrl: String) = downloadRepository.downloadPhoto(photoUrl)
    }
