package com.example.photogallery.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.home.navigation.homeRoute
import com.example.home.navigation.homeScreen
import com.example.randomphoto.navigation.randomPhotoScreen


@Composable
fun PGNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = homeRoute
    ) {
        homeScreen()
        randomPhotoScreen()
    }
}