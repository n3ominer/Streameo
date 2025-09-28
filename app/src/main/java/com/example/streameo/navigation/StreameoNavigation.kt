package com.example.streameo.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.streameo.screens.BrowseScreen
import com.example.streameo.screens.DetailScreen
import com.example.streameo.screens.HomeScreen
import com.example.streameo.screens.ProfileScreen
import com.example.streameo.viewmodels.MovieViewModel

/**
 * Main navigation graph for the Streameo app
 */
@Composable
fun StreameoNavigation(
    navController: NavHostController,
    viewModel: MovieViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavigationDestinations.HOME,
        modifier = modifier
    ) {
        // Home screen
        composable(NavigationDestinations.HOME) {
            Surface(color = Color.Black) {
                HomeScreen(
                    viewModel = viewModel,
                    onMovieClick = { movieId ->
                        navController.navigate(NavigationDestinations.createDetailRoute(movieId))
                    }
                )
            }
        }
        
        // Search screen
        composable(NavigationDestinations.SEARCH) {
            Surface(color = Color.Black) {
                BrowseScreen(
                    viewModel = viewModel,
                    onMovieClick = { movieId ->
                        navController.navigate(NavigationDestinations.createDetailRoute(movieId))
                    }
                )
            }
        }
        
        // Profile screen
        composable(NavigationDestinations.PROFILE) {
            Surface(color = Color.Black) {
                ProfileScreen()
            }
        }
        
        // Detail screen
        composable(
            route = NavigationDestinations.DETAIL,
            arguments = listOf(
                navArgument(NavigationDestinations.Args.MOVIE_ID) { 
                    type = NavType.StringType 
                }
            )
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString(NavigationDestinations.Args.MOVIE_ID)
            
            // Select movie in viewModel
            movieId?.let { viewModel.selectMovie(it) }
            val movie = viewModel.selectedMovie.collectAsState().value
            
            Surface {
                DetailScreen(
                    movie = movie,
                    onBack = {
                        navController.popBackStack()
                        viewModel.clearSelection()
                    }
                )
            }
        }
    }
}