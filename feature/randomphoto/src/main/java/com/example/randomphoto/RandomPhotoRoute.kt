package com.example.randomphoto

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun RandomPhotoRoute(
    randomPhotoViewModel: RandomPhotoViewModel = hiltViewModel()
) {
    val randomPhoto = randomPhotoViewModel.randomPhoto.collectAsLazyPagingItems()

    RandomPhotoScreen(randomPhoto)
}