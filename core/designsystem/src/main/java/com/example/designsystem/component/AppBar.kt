package com.example.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.R
import com.example.designsystem.theme.Gray30
import com.example.designsystem.theme.PhotoGalleryTheme

@Composable
fun PGAppBar(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_prography),
            contentDescription = "app title",
            modifier = Modifier.padding(top = 22.dp, bottom = 18.dp)
        )
        HorizontalDivider(
            modifier = Modifier.align(Alignment.BottomCenter),
            thickness = 1.5.dp,
            color = Gray30
        )
    }
}

@Preview
@Composable
fun PGAppBarPreview() {
    PhotoGalleryTheme {
        PGAppBar()
    }
}