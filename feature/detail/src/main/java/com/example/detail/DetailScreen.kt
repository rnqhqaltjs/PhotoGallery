package com.example.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.detail.component.DetailBottom
import com.example.detail.component.DetailHeader
import com.example.model.Photo

@Composable
fun DetailScreen(
    popBackStack: () -> Unit,
    detailUiState: DetailUiState,
    onBookmarkClick: (Photo) -> Unit,
    isBookmarked: Boolean,
) {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.9f))
                .statusBarsPadding()
                .navigationBarsPadding(),
    ) {
        when (detailUiState) {
            is DetailUiState.Loading -> {
                CircularProgressIndicator(
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center),
                )
            }

            is DetailUiState.Failure -> {
                Text(
                    text = "오류가 발생했습니다.",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center),
                )
            }

            is DetailUiState.Success -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    DetailHeader(
                        userName = detailUiState.data.userName,
                        onCloseClick = { popBackStack() },
                        onDownloadClick = {},
                        onBookmarkClick = { onBookmarkClick(detailUiState.data) },
                        isBookmarked,
                    )
                    AsyncImage(
                        model = detailUiState.data.url,
                        contentDescription = "detail image",
                        contentScale = ContentScale.FillWidth,
                        modifier =
                            Modifier
                                .padding(10.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .align(Alignment.CenterHorizontally),
                    )
                    DetailBottom(
                        title = detailUiState.data.title,
                        description = detailUiState.data.description,
                    )
                }
            }
        }
    }
}
