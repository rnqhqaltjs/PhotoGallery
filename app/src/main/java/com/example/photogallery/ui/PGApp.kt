package com.example.photogallery.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.designsystem.component.PGNavigationBar
import com.example.designsystem.component.PGNavigationBarItem
import com.example.photogallery.navigation.PGNavHost
import com.example.photogallery.navigation.Screen

@Composable
fun PGApp() {
    val navHostController = rememberNavController()
    val backStackEntry by navHostController.currentBackStackEntryAsState()

    Scaffold(
        modifier = Modifier,
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
                currentDestination = backStackEntry?.destination
            )
        },
    ) { contentPadding ->
        Box(
            modifier =
            Modifier.padding(contentPadding)
        ) {
            PGNavHost(
                modifier = Modifier
                    .fillMaxSize(),
                navController = navHostController
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
) {
    PGNavigationBar(
        modifier = modifier,
    ) {
        destination.forEach { destination ->
            val isSelected = currentDestination?.route == destination.route

            PGNavigationBarItem(
                selected = isSelected,
                onClick = { onNavigateToDestination(destination) },
                iconResId = destination.iconResId
            )
        }
    }
}