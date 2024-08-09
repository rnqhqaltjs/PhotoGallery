package com.example.randomphoto

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import com.example.designsystem.R
import com.example.domain.model.PhotosResponseEntity
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RandomPhotoScreen(
    randomPhoto: LazyPagingItems<PhotosResponseEntity>,
    onBookmarkClick: (PhotosResponseEntity) -> Unit,
    onNavigateToDetail: (String) -> Unit,
    showSnackbar: (String) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    val pagerState = rememberPagerState(
        initialPage = 1,
        pageCount = { randomPhoto.itemCount }
    )

    HorizontalPager(
        modifier = Modifier
            .padding(
                top = 30.dp,
                bottom = 50.dp
            ),
        pageSpacing = 10.dp,
        contentPadding = PaddingValues(horizontal = 25.dp),
        state = pagerState
    ) { pageIndex ->
        RandomPhoto(
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
            onInfoClick = { randomPhoto[pageIndex]?.let { onNavigateToDetail(it.id) } }
        )
    }
}

@Composable
fun RandomPhoto(
    photoUrl: String?,
    onCloseClick: () -> Unit,
    onBookmarkClick: () -> Unit,
    onInfoClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .weight(0.68f)
                    .background(color = Color.Black)
            ) {
                AsyncImage(
                    model = photoUrl,
                    contentDescription = "randomPhoto image",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 32.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_close_btn),
                    contentDescription = "item remove",
                    modifier = Modifier.clickable { onCloseClick() }
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_bookmark_btn),
                    contentDescription = "add bookmark",
                    modifier = Modifier.clickable { onBookmarkClick() }
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_info_btn),
                    contentDescription = "item info",
                    modifier = Modifier.clickable { onInfoClick() }
                )
            }
        }
    }
}