package com.example.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.designsystem.R
import com.example.domain.model.PhotosResponseEntity

@Composable
fun DetailScreen(
    popBackStack: () -> Unit,
    detailUiState: DetailUiState,
    onBookmarkClick: (PhotosResponseEntity) -> Unit,
    isBookmarked: Boolean
) {
//    val systemUiController = rememberSystemUiController()
//
//    systemUiController.setStatusBarColor(
//        color = Color.Black.copy(alpha = 0.9f),
//        darkIcons = false
//    )

    if (detailUiState !is DetailUiState.Success) return
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.9f)),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        DetailHeader(
            userName = detailUiState.data.userName,
            onCloseClick = { popBackStack() },
            onDownloadClick = {},
            onBookmarkClick = { onBookmarkClick(detailUiState.data) },
            isBookmarked
        )
        AsyncImage(
            model = detailUiState.data.url,
            contentDescription = "detail image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(12.dp))
                .align(Alignment.CenterHorizontally)
        )
        DetailBottom(
            title = detailUiState.data.title ?: "Title",
            description = detailUiState.data.description ?: "description\ndescription은 최대 2줄"
        )
    }
}

@Composable
fun DetailHeader(
    userName: String,
    onCloseClick: () -> Unit,
    onDownloadClick: () -> Unit,
    onBookmarkClick: () -> Unit,
    isBookmarked: Boolean
) {
    Row(
        modifier = Modifier.padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_close_black),
            contentDescription = "close",
            modifier = Modifier
                .scale(1.14f)
                .clickable(onClick = onCloseClick)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = userName,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold))
            ),
            color = Color.White,
            modifier = Modifier.widthIn(max = 200.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.ic_download),
            contentDescription = "download",
            modifier = Modifier
                .scale(1.14f)
                .clickable(onClick = onDownloadClick)
        )
        Spacer(modifier = Modifier.width(26.dp))
        Image(
            painter = painterResource(
                if (isBookmarked)
                    R.drawable.ic_bookmark_white
                else
                    R.drawable.ic_bookmark_gray
            ),
            contentDescription = "bookmark state",
            modifier = Modifier
                .scale(1.14f)
                .clickable(onClick = onBookmarkClick)
        )
        Spacer(modifier = Modifier.width(6.dp))
    }
}

@Composable
fun DetailBottom(
    title: String,
    description: String
) {
    Column(
        modifier = Modifier.padding(
            start = 12.dp,
            end = 12.dp,
            bottom = 12.dp
        ),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_semi_bold))
            ),
            color = Color.White
        )
        Text(
            text = description,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_medium))
            ),
            color = Color.White
        )
        Text(
            text = "#tag #tag #tag #tag",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_medium))
            ),
            color = Color.White
        )
    }
}