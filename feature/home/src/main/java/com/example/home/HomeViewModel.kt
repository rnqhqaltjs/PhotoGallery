package com.example.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.model.PhotosResponseEntity
import com.example.domain.usecase.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {


    val photos: Flow<PagingData<PhotosResponseEntity>> =
        getPhotosUseCase().distinctUntilChanged().cachedIn(viewModelScope)
}