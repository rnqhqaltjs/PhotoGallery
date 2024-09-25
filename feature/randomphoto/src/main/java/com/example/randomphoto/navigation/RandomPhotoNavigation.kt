package com.example.randomphoto.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.randomphoto.RandomPhotoRoute

const val randomPhotoRoute = "random_photo_route"

fun NavController.navigateToRandomPhoto(navOptions: NavOptions? = null) {
    navigate(randomPhotoRoute, navOptions = navOptions)
}

fun NavGraphBuilder.randomPhotoScreen(
    showSnackbar: (String) -> Unit,
    onNavigateToDetail: (String) -> Unit,
) {
    composable(
        route = randomPhotoRoute,
    ) { _ ->
        RandomPhotoRoute(
            showSnackbar = showSnackbar,
            onNavigateToDetail = onNavigateToDetail,
        )
    }
}
