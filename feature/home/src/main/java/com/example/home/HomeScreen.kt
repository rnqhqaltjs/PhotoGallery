package com.example.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import coil.compose.AsyncImage
import com.example.designsystem.R
import com.example.designsystem.theme.Gray30
import com.example.domain.model.PhotosResponseEntity

@Composable
fun HomeScreen(
    photos: LazyPagingItems<PhotosResponseEntity>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_prography),
            contentDescription = "title",
            modifier = Modifier.padding(top = 22.dp, bottom = 16.dp)
        )
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.5.dp,
            color = Gray30
        )

        Text(
            text = "북마크",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp, top = 30.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_extra_bold))
            )
        )

        Text(
            text = "최신 이미지",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp, top = 30.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_extra_bold))
            )
        )

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
        ) {
            items(
                count = photos.itemCount,
                key = photos.itemKey()
            ) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                ) {
                    AsyncImage(
                        model = photos[it]?.url,
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    PhotoGalleryTheme {
//        HomeScreen()
//    }
//}