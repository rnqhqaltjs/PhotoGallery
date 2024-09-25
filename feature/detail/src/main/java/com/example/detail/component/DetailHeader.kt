package com.example.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystem.R
import com.example.designsystem.noRippleClickable

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
                .noRippleClickable(onClick = onCloseClick)
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
                .noRippleClickable(onClick = onDownloadClick)
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
                .noRippleClickable(onClick = onBookmarkClick)
        )
        Spacer(modifier = Modifier.width(6.dp))
    }
}