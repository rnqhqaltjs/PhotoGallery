package com.example.randomphoto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.model.PhotosResponseEntity
import com.example.domain.repository.BookmarkRepository
import com.example.domain.usecase.GetRandomPhotoUseCase
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
    val randomPhoto: Flow<PagingData<PhotosResponseEntity>> =
        getRandomPhotoUseCase().distinctUntilChanged().cachedIn(viewModelScope)

    fun addBookmark(photosResponseEntity: PhotosResponseEntity) {
        viewModelScope.launch {
            try {
                bookmarkRepository.addBookmark(photosResponseEntity)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}