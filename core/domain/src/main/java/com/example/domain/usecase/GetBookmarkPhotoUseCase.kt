package com.example.domain.usecase

import com.example.domain.repository.BookmarkRepository
import com.example.model.Photo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookmarkPhotoUseCase
    @Inject
    constructor(
        private val bookmarkRepository: BookmarkRepository,
    ) {
        operator fun invoke(): Flow<List<Photo>> = bookmarkRepository.getBookmarkPhoto()
    }
