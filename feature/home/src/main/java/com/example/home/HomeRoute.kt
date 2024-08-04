package com.example.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val photos = homeViewModel.photos.collectAsLazyPagingItems()

    HomeScreen(photos)
}