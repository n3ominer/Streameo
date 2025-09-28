package com.example.streameo.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * Navigation utilities for the Streameo app
 */
object NavigationUtils {
    
    /**
     * Get the current route from navigation controller
     */
    @Composable
    fun getCurrentRoute(navController: NavHostController): String? {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        return navBackStackEntry?.destination?.route
    }
}