package com.example.randomphoto

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.model.Photo
import com.example.randomphoto.component.RandomPhotoCard
import kotlinx.coroutines.launch

@Composable
fun RandomPhotoScreen(
    randomPhoto: LazyPagingItems<Photo>,
    onBookmarkClick: (Photo) -> Unit,
    onNavigateToDetail: (String) -> Unit,
    showSnackbar: (String) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    val pagerState =
        rememberPagerState(
            initialPage = 1,
            pageCount = { randomPhoto.itemCount },
        )

    HorizontalPager(
        modifier =
            Modifier
                .padding(
                    top = 30.dp,
                    bottom = 50.dp,
                ),
        pageSpacing = 10.dp,
        contentPadding = PaddingValues(horizontal = 25.dp),
        state = pagerState,
    ) { pageIndex ->
        RandomPhotoCard(
            photoUrl = randomPhoto[pageIndex]?.url,
            onCloseClick = {},
            onBookmarkClick = {
                randomPhoto[pageIndex]?.let {
                    onBookmarkClick(it)
                }
                showSnackbar("북마크 완료")
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pageIndex + 1)
                }
            },
            onInfoClick = { randomPhoto[pageIndex]?.let { onNavigateToDetail(it.id) } },
        )
    }
}
