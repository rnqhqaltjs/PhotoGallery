package com.example.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
    photos: LazyPagingItems<PhotosResponseEntity>
) {
    Scaffold(topBar = { PGAppBar() }) { paddingValue ->
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = paddingValue.calculateTopPadding()
                )
        ) {
            item(span = StaggeredGridItemSpan.FullLine) {
                Text(
                    text = "최신 이미지",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_extra_bold))
                    ),
                    modifier = Modifier.padding(top = 30.dp, bottom = 15.dp)
                )
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
                                .padding(start = 8.dp, bottom = 8.dp)
                        )
                    }
                }
            }
        }
    }
}