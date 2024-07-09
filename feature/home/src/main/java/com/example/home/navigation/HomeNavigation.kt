package com.example.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.home.HomeRoute

const val homeRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions) {
    navigate(homeRoute, navOptions = navOptions)
}

fun NavGraphBuilder.homeScreen() {
    composable(
        route = homeRoute,
    ) { _ ->
        HomeRoute()
    }
}