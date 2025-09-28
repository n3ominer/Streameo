package com.example.streameo.ui.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.example.streameo.navigation.NavigationDestinations
import com.example.streameo.utils.NavigationUtils

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem(NavigationDestinations.HOME, Icons.Default.Home, "Accueil"),
        BottomNavItem(NavigationDestinations.SEARCH, Icons.Default.Search, "Recherche"),
        BottomNavItem(NavigationDestinations.PROFILE, Icons.Default.Person, "Profil")
    )

    NavigationBar {
        val currentRoute = NavigationUtils.getCurrentRoute(navController)
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) }
            )
        }
    }
}

data class BottomNavItem(val route: String, val icon: ImageVector, val label: String)