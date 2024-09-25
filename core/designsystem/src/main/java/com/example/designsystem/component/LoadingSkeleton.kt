package com.example.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.designsystem.shimmerLoadingAnimation
import com.example.designsystem.theme.Gray20

@Composable
fun LoadingSkeleton() {
    Box(
        modifier =
            Modifier
                .clip(shape = RoundedCornerShape(24.dp))
                .background(color = Gray20)
                .height(200.dp)
                .shimmerLoadingAnimation(),
    )
}
