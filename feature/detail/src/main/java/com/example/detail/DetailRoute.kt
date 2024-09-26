package com.example.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DetailRoute(
    popBackStack: () -> Unit,
    detailViewModel: DetailViewModel = hiltViewModel(),
) {
    val photoDetail by detailViewModel.photoDetail.collectAsStateWithLifecycle()
    val isBookmarked by detailViewModel.isBookmarked.collectAsStateWithLifecycle()

    DetailScreen(
        popBackStack = popBackStack,
        detailUiState = photoDetail,
        isBookmarked = isBookmarked,
        onDownloadClick = { detailViewModel.downloadPhoto(it) },
        onBookmarkClick = { detailViewModel.toggleBookmark(it) },
    )
}
