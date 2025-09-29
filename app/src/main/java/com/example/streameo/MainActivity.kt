package com.example.streameo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.streameo.navigation.StreameoNavigation
import com.example.streameo.ui.components.navigation.BottomNavigationBar
import com.example.streameo.ui.theme.StreameoTheme
import com.example.streameo.viewmodels.MovieViewModel
import kotlinx.coroutines.delay


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
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(3000)
        isLoading = false
    }

    val navController = rememberNavController()
    val viewModel: MovieViewModel = viewModel()
    
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator()
                    Text(
                        "Chargement de votre contenu...",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                }
            } else {
                StreameoNavigation(
                    navController = navController,
                    viewModel = viewModel,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}


