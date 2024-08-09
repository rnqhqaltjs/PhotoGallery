package com.example.randomphoto

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun RandomPhotoRoute(
    randomPhotoViewModel: RandomPhotoViewModel = hiltViewModel(),
    showSnackbar: (String) -> Unit,
    onNavigateToDetail: (String) -> Unit
) {
    val randomPhoto = randomPhotoViewModel.randomPhoto.collectAsLazyPagingItems()

    RandomPhotoScreen(
        randomPhoto = randomPhoto,
        onBookmarkClick = { randomPhotoViewModel.addBookmark(it) },
        onNavigateToDetail = onNavigateToDetail,
        showSnackbar = showSnackbar
    )
}