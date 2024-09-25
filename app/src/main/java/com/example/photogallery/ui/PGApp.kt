package com.example.photogallery.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.designsystem.component.PGAppBar
import com.example.designsystem.component.PGNavigationBar
import com.example.designsystem.component.PGNavigationBarItem
import com.example.photogallery.navigation.PGNavHost
import com.example.photogallery.navigation.Screen
import com.example.photogallery.navigation.shouldShowBottomBar

@Composable
fun PGApp() {
    val navHostController = rememberNavController()
    val backStackEntry by navHostController.currentBackStackEntryAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    val isVisible = shouldShowBottomBar(currentDestination = backStackEntry?.destination)

    Scaffold(
        contentWindowInsets = WindowInsets(0.dp),
        modifier = Modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            PGAppBar(
                modifier = Modifier.statusBarsPadding(),
                isVisible = isVisible,
            )
        },
        bottomBar = {
            PGBottomBar(
                destination = Screen.entries,
                onNavigateToDestination = { destination ->
                    navHostController.navigate(destination.route) {
                        popUpTo(navHostController.graph.startDestinationId) {
                            saveState = true
                            inclusive = false
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                currentDestination = backStackEntry?.destination,
                modifier = Modifier.navigationBarsPadding(),
                isVisible = isVisible,
            )
        },
    ) { contentPadding ->
        Box(
            modifier = Modifier.padding(contentPadding),
        ) {
            PGNavHost(
                modifier = Modifier.fillMaxSize(),
                navController = navHostController,
                snackbarHostState = snackbarHostState,
            )
        }
    }
}

@Composable
private fun PGBottomBar(
    destination: List<Screen>,
    onNavigateToDestination: (Screen) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
    isVisible: Boolean,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        modifier = modifier,
    ) {
        PGNavigationBar(
            modifier = modifier,
        ) {
            destination.forEach { destination ->
                val isSelected = currentDestination?.route == destination.route

                PGNavigationBarItem(
                    selected = isSelected,
                    onClick = { onNavigateToDestination(destination) },
                    iconResId = destination.iconResId,
                )
            }
        }
    }
}
