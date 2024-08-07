package com.example.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.common.Result
import com.example.common.asResult
import com.example.domain.model.PhotosResponseEntity
import com.example.domain.repository.BookmarkRepository
import com.example.domain.usecase.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getPhotosUseCase: GetPhotosUseCase,
    private val bookmarkRepository: BookmarkRepository
) : ViewModel() {
    val photos: Flow<PagingData<PhotosResponseEntity>> =
        getPhotosUseCase().distinctUntilChanged().cachedIn(viewModelScope)

    fun getBookmarkPhoto() {
        viewModelScope.launch {
            bookmarkRepository.getBookmarkPhoto()
                .asResult()
                .map {
                    when (it) {
                        is Result.Error -> BookmarkUiState.LoadFail(it.exception)
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
    }
}

sealed interface BookmarkUiState {
    data class Success(val data: List<PhotosResponseEntity>) : BookmarkUiState

    data class LoadFail(val t: Throwable?) : BookmarkUiState
    
    data object Loading : BookmarkUiState
}