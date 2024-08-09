package com.example.detail.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.detail.DetailRoute

const val detailRoute = "detail_route"

fun NavController.navigateToDetail(
    itemId: String,
    navOptions: NavOptions? = null
) {
    navigate("$detailRoute/$itemId", navOptions = navOptions)
}

fun NavGraphBuilder.detailScreen(
    popBackStack: () -> Unit
) {
    composable(
        route = "$detailRoute/{itemId}",
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        }
    ) { _ ->
        DetailRoute(popBackStack = popBackStack)
    }
}