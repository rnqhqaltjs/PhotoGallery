package com.example.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.home.LoadingSkeleton

@Composable
fun BookmarkCard(
    imageUrl: String,
    onClick: () -> Unit
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = "bookmark image",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .height(120.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() },
        loading = {
            LoadingSkeleton()
        }
    )
}