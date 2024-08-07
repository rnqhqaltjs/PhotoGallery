package com.example.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import coil.compose.AsyncImage
import com.example.designsystem.R
import com.example.designsystem.component.PGAppBar
import com.example.domain.model.PhotosResponseEntity

@Composable
fun HomeScreen(
    photos: LazyPagingItems<PhotosResponseEntity>,
    bookmarkUiState: BookmarkUiState
) {
    Scaffold(topBar = { PGAppBar() }) { paddingValues ->
        if (bookmarkUiState !is BookmarkUiState.Success) return@Scaffold
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(
                horizontal = 20.dp,
                vertical = 10.dp
            ),
            verticalItemSpacing = 10.dp,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())
        ) {
            if (bookmarkUiState.data.isNotEmpty()) {
                item(span = StaggeredGridItemSpan.FullLine) {
                    TitleText(title = "북마크")
                }

                item(span = StaggeredGridItemSpan.FullLine) {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(
                            count = bookmarkUiState.data.count()
                        ) {
                            AsyncImage(
                                model = bookmarkUiState.data[it].url,
                                contentDescription = "bookmark image",
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier
                                    .height(120.dp)
                                    .clip(RoundedCornerShape(12.dp))
                            )
                        }
                    }
                }
            }

            item(span = StaggeredGridItemSpan.FullLine) {
                TitleText(title = "최신 이미지")
            }

            items(
                count = photos.itemCount,
                key = photos.itemKey(),
            ) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    onClick = {}
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        AsyncImage(
                            model = photos[it]?.url,
                            contentDescription = "photos image",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxSize()
                        )
                        Text(
                            text = photos[it]?.description ?: "",
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontFamily = FontFamily(Font(R.font.pretendard_medium))
                            ),
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(
                                    start = 8.dp,
                                    bottom = 8.dp,
                                    end = 8.dp
                                )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TitleText(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.pretendard_extra_bold))
        ),
        modifier = Modifier.padding(
            top = 20.dp,
            bottom = 10.dp
        )
    )
}