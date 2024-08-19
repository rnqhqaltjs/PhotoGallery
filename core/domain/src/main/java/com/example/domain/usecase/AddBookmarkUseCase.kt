package com.example.domain.usecase

import com.example.domain.repository.BookmarkRepository
import com.example.model.Photo
import javax.inject.Inject

class AddBookmarkUseCase @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
) {
    suspend operator fun invoke(photo: Photo) =
        bookmarkRepository.addBookmark(photo)
}