package com.example.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.example.designsystem.R
import com.example.designsystem.component.LoadingSkeleton
import com.example.home.component.BookmarkCard
import com.example.home.component.PhotoCard
import com.example.home.component.SectionTitle
import com.example.model.Photo

@Composable
fun HomeScreen(
    photo: LazyPagingItems<Photo>,
    bookmarkUiState: BookmarkUiState,
    onNavigateToDetail: (String) -> Unit,
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding =
            PaddingValues(
                horizontal = 20.dp,
                vertical = 10.dp,
            ),
        verticalItemSpacing = 10.dp,
        modifier = Modifier.fillMaxSize(),
    ) {
        if (bookmarkUiState is BookmarkUiState.Success && bookmarkUiState.data.isNotEmpty()) {
            item(span = StaggeredGridItemSpan.FullLine) {
                SectionTitle(title = stringResource(R.string.bookmark))
            }

            item(span = StaggeredGridItemSpan.FullLine) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items(
                        count = bookmarkUiState.data.count(),
                    ) { index ->
                        BookmarkCard(
                            imageUrl = bookmarkUiState.data[index].url,
                            onClick = { onNavigateToDetail(bookmarkUiState.data[index].id) },
                        )
                    }
                }
            }
        }

        item(span = StaggeredGridItemSpan.FullLine) {
            SectionTitle(title = stringResource(R.string.recent_image))
        }

        if (photo.loadState.refresh == LoadState.Loading) {
            items(6) {
                LoadingSkeleton()
            }
        } else {
            items(
                count = photo.itemCount,
                key = photo.itemKey(),
            ) { index ->
                PhotoCard(
                    photoUrl = photo[index]?.url,
                    title = photo[index]?.title,
                ) {
                    photo[index]?.let { onNavigateToDetail(it.id) }
                }
            }
        }
    }
}
