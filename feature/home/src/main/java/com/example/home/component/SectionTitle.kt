package com.example.home.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystem.R

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style =
            TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_extra_bold)),
            ),
        modifier =
            Modifier.padding(
                top = 20.dp,
                bottom = 10.dp,
            ),
    )
}
