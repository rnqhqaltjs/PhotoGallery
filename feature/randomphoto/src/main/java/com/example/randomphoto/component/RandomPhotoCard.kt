package com.example.randomphoto.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.R
import com.example.designsystem.noRippleClickable

@Composable
fun RandomPhotoCard(
    photoUrl: String?,
    onCloseClick: () -> Unit,
    onBookmarkClick: () -> Unit,
    onInfoClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            ),
        colors =
            CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
        ) {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .weight(0.68f)
                        .background(color = Color.Black),
            ) {
                AsyncImage(
                    model = photoUrl,
                    contentDescription = "randomPhoto image",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.align(Alignment.Center),
                )
            }
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 32.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_close_btn),
                    contentDescription = "item remove",
                    modifier = Modifier.noRippleClickable { onCloseClick() },
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_bookmark_btn),
                    contentDescription = "add bookmark",
                    modifier = Modifier.noRippleClickable { onBookmarkClick() },
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_info_btn),
                    contentDescription = "item info",
                    modifier = Modifier.noRippleClickable { onInfoClick() },
                )
            }
        }
    }
}
