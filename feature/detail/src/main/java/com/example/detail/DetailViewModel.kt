package com.example.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Result
import com.example.common.asResult
import com.example.domain.repository.BookmarkRepository
import com.example.domain.usecase.AddBookmarkUseCase
import com.example.domain.usecase.DeleteBookmarkUseCase
import com.example.domain.usecase.GetPhotoDetailUseCase
import com.example.model.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    getPhotoDetailUseCase: GetPhotoDetailUseCase,
    savedStateHandle: SavedStateHandle,
    bookmarkRepository: BookmarkRepository,
    private val addBookmarkUseCase: AddBookmarkUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
) : ViewModel() {
    private val id: StateFlow<String> = savedStateHandle.getStateFlow("itemId", "")

    @OptIn(ExperimentalCoroutinesApi::class)
    val photoDetail: StateFlow<DetailUiState> = id.flatMapLatest { photoId ->
        getPhotoDetailUseCase(photoId)
            .asResult()
            .map { result ->
                when (result) {
                    is Result.Error -> DetailUiState.Failure(result.exception)
                    is Result.Loading -> DetailUiState.Loading
                    is Result.Success -> DetailUiState.Success(result.data)
                }
            }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = DetailUiState.Loading
    )

    val isBookmarked = bookmarkRepository.isBookmarked(id.value)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )

    fun toggleBookmark(photo: Photo) {
        viewModelScope.launch {
            try {
                if (isBookmarked.value) {
                    deleteBookmarkUseCase(photo)
                } else {
                    addBookmarkUseCase(photo)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

sealed interface DetailUiState {
    data class Success(val data: Photo) : DetailUiState
    data class Failure(val t: Throwable?) : DetailUiState
    data object Loading : DetailUiState
}