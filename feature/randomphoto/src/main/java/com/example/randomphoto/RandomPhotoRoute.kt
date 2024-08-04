package com.example.randomphoto

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RandomPhotoRoute(
    randomPhotoViewModel: RandomPhotoViewModel = hiltViewModel()
) {
    RandomPhotoScreen()
}