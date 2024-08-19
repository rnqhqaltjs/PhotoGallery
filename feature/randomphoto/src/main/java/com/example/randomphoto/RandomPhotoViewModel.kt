package com.example.randomphoto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.repository.BookmarkRepository
import com.example.domain.usecase.GetRandomPhotoUseCase
import com.example.model.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomPhotoViewModel @Inject constructor(
    getRandomPhotoUseCase: GetRandomPhotoUseCase,
    private val bookmarkRepository: BookmarkRepository,
) : ViewModel() {
    val randomPhoto: Flow<PagingData<Photo>> =
        getRandomPhotoUseCase().distinctUntilChanged().cachedIn(viewModelScope)

    fun addBookmark(photo: Photo) {
        viewModelScope.launch {
            try {
                bookmarkRepository.addBookmark(photo)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}