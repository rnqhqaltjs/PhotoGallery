package com.example.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import coil.compose.SubcomposeAsyncImage
import com.example.designsystem.R
import com.example.designsystem.component.LoadingSkeleton

@Composable
fun PhotoCard(
    photoUrl: String?,
    title: String?,
    onClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        onClick = onClick,
        modifier = Modifier.fillMaxSize(),
    ) {
        Box {
            SubcomposeAsyncImage(
                model = photoUrl,
                contentDescription = "photos image",
                contentScale = ContentScale.FillWidth,
                loading = {
                    LoadingSkeleton()
                },
            )
            Text(
                text = title ?: "",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style =
                    TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_medium)),
                    ),
                color = Color.White,
                modifier =
                    Modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp),
            )
        }
    }
}
