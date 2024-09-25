package com.example.photogallery.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import com.example.designsystem.R
import com.example.home.navigation.homeRoute
import com.example.randomphoto.navigation.randomPhotoRoute

enum class Screen(
    val route: String,
    val iconResId: Int,
) {
    Home(
        route = homeRoute,
        R.drawable.ic_home,
    ),
    RandomPhoto(
        route = randomPhotoRoute,
        R.drawable.ic_cards,
    ),
}

@Composable
fun shouldShowBottomBar(currentDestination: NavDestination?): Boolean {
    val currentRoute = currentDestination?.route ?: return false
    return Screen.entries.any { it.route == currentRoute }
}
