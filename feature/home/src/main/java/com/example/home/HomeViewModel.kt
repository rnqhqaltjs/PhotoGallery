package com.example.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.common.Result
import com.example.common.asResult
import com.example.domain.usecase.GetBookmarkPhotoUseCase
import com.example.domain.usecase.GetPhotosUseCase
import com.example.model.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getPhotosUseCase: GetPhotosUseCase,
    getBookmarkPhotoUseCase: GetBookmarkPhotoUseCase
) : ViewModel() {
    val photo: Flow<PagingData<Photo>> =
        getPhotosUseCase().distinctUntilChanged().cachedIn(viewModelScope)

    val bookmarkPhoto = getBookmarkPhotoUseCase()
        .asResult()
        .map {
            when (it) {
                is Result.Error -> BookmarkUiState.Failure(it.exception)
                is Result.Loading -> BookmarkUiState.Loading
                is Result.Success -> BookmarkUiState.Success(it.data)
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = BookmarkUiState.Loading
        )
}

sealed interface BookmarkUiState {
    data class Success(val data: List<Photo>) : BookmarkUiState
    data class Failure(val t: Throwable?) : BookmarkUiState
    data object Loading : BookmarkUiState
}