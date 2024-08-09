package com.example.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Result
import com.example.common.asResult
import com.example.domain.model.PhotosResponseEntity
import com.example.domain.repository.BookmarkRepository
import com.example.domain.usecase.GetPhotoDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    getPhotoDetailUseCase: GetPhotoDetailUseCase,
    savedStateHandle: SavedStateHandle,
    private val bookmarkRepository: BookmarkRepository
) : ViewModel() {
    private val id = savedStateHandle.getStateFlow("itemId", "")

    val photoDetail = getPhotoDetailUseCase(id.value)
        .asResult()
        .map {
            when (it) {
                is Result.Error -> DetailUiState.Failure(it.exception)
                is Result.Loading -> DetailUiState.Loading
                is Result.Success -> DetailUiState.Success(it.data)
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = DetailUiState.Loading
        )

    fun addBookmark(photosResponseEntity: PhotosResponseEntity) {
        viewModelScope.launch {
            try {
                bookmarkRepository.addBookmark(photosResponseEntity)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteBookmark(photosResponseEntity: PhotosResponseEntity) {
        viewModelScope.launch {
            try {
                bookmarkRepository.deleteBookmark(photosResponseEntity)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    val isBookmarked = bookmarkRepository.isBookmarked(id.value)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )

    fun toggleBookmark(photosResponseEntity: PhotosResponseEntity) {
        viewModelScope.launch {
            if (isBookmarked.value) {
                deleteBookmark(photosResponseEntity)
            } else {
                addBookmark(photosResponseEntity)
            }
        }
    }
}

sealed interface DetailUiState {
    data class Success(val data: PhotosResponseEntity) : DetailUiState
    data class Failure(val t: Throwable?) : DetailUiState
    data object Loading : DetailUiState
}