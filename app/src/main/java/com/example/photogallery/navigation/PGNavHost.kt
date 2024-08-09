package com.example.photogallery.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.detail.navigation.detailScreen
import com.example.detail.navigation.navigateToDetail
import com.example.home.navigation.homeRoute
import com.example.home.navigation.homeScreen
import com.example.randomphoto.navigation.randomPhotoScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun PGNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    snackbarHostState: SnackbarHostState,
) {
    val coroutineScope = rememberCoroutineScope()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = homeRoute
    ) {
        homeScreen(
            onNavigateToDetail = { itemId ->
                navController.navigateToDetail(itemId)
            }
        )
        randomPhotoScreen(
            showSnackbar = { message ->
                snackbarHostState.showMessage(coroutineScope, message)
            },
            onNavigateToDetail = { itemId ->
                navController.navigateToDetail(itemId)
            }
        )
        detailScreen(popBackStack = navController::popBackStack)
    }
}

private fun SnackbarHostState.showMessage(
    coroutineScope: CoroutineScope,
    text: String,
) {
    coroutineScope.launch {
        currentSnackbarData?.dismiss()
        showSnackbar(text)
    }
}