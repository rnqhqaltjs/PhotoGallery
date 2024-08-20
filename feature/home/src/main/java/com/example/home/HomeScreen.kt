package com.example.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.example.designsystem.shimmerLoadingAnimation
import com.example.designsystem.theme.Gray20
import com.example.home.component.BookmarkCard
import com.example.home.component.PhotoCard
import com.example.home.component.SectionTitle
import com.example.model.Photo

@Composable
fun HomeScreen(
    photo: LazyPagingItems<Photo>,
    bookmarkUiState: BookmarkUiState,
    onNavigateToDetail: (String) -> Unit
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(
            horizontal = 20.dp,
            vertical = 10.dp
        ),
        verticalItemSpacing = 10.dp,
        modifier = Modifier.fillMaxSize()
    ) {
        if (bookmarkUiState is BookmarkUiState.Success && bookmarkUiState.data.isNotEmpty()) {
            item(span = StaggeredGridItemSpan.FullLine) {
                SectionTitle(title = "북마크")
            }

            item(span = StaggeredGridItemSpan.FullLine) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(
                        count = bookmarkUiState.data.count()
                    ) { index ->
                        BookmarkCard(
                            imageUrl = bookmarkUiState.data[index].url,
                            onClick = { onNavigateToDetail(bookmarkUiState.data[index].id) }
                        )
                    }
                }
            }
        }

        item(span = StaggeredGridItemSpan.FullLine) {
            SectionTitle(title = "최신 이미지")
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
                    title = photo[index]?.title
                ) {
                    photo[index]?.let { onNavigateToDetail(it.id) }
                }
            }
        }
    }
}

@Composable
fun LoadingSkeleton() {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(24.dp))
            .background(color = Gray20)
            .height(200.dp)
            .shimmerLoadingAnimation()
    )
}
