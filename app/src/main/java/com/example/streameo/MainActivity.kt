package com.example.streameo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.streameo.navigation.StreameoNavigation
import com.example.streameo.ui.components.navigation.BottomNavigationBar
import com.example.streameo.ui.theme.StreameoTheme
import com.example.streameo.viewmodels.MovieViewModel


/**
 * Main activity for the Streameo app
 * Simplified and cleaned up to use the new navigation architecture
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StreameoTheme {
                StreameoApp()
            }
        }
    }
}

/**
 * Main composable for the Streameo app
 */
@Composable
private fun StreameoApp() {
    val navController = rememberNavController()
    val viewModel: MovieViewModel = viewModel()
    
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        StreameoNavigation(
            navController = navController,
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding)
        )
    }
}


