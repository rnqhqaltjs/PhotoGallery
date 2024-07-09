package com.example.photogallery.navigation

import com.example.designsystem.R
import com.example.home.navigation.homeRoute
import com.example.randomphoto.navigation.randomPhotoRoute

enum class Screen(val route: String, val iconResId: Int) {
    Home(
        route = homeRoute,
        R.drawable.ic_home
    ),
    RandomPhoto(
        route = randomPhotoRoute,
        R.drawable.ic_cards
    )
}