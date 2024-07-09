package com.example.randomphoto.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.example.randomphoto.RandomPhotoRoute

const val randomPhotoRoute = "random_photo_route"

fun NavController.navigateToRandomPhoto(navOptions: NavOptionsBuilder.() -> Unit = {}) {
    this.navigate(randomPhotoRoute, navOptions)
}

fun NavGraphBuilder.randomPhotoScreen() {
    composable(
        route = randomPhotoRoute,
    ) { _ ->
        RandomPhotoRoute()
    }
}