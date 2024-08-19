package com.example.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onNavigateToDetail: (String) -> Unit
) {
    val photos = homeViewModel.photo.collectAsLazyPagingItems()
    val bookmarkPhoto by homeViewModel.bookmarkPhoto.collectAsStateWithLifecycle()

    HomeScreen(
        photo = photos,
        bookmarkUiState = bookmarkPhoto,
        onNavigateToDetail = onNavigateToDetail
    )
}