package com.example.streameo.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.streameo.ui.components.MovieCard
import com.example.streameo.ui.components.MovieHero
import com.example.streameo.ui.components.RoundedIconButton
import com.example.streameo.viemodels.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: MovieViewModel, onMovieClick: (String) -> Unit) {
    val moviesState = viewModel.movies.collectAsState()
    val trendingState = viewModel.trending.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Movies") },
            actions = {
                RoundedIconButton(onClick = {})
            }
        )

        // Hero: use first trending item if present
        val hero = trendingState.value.firstOrNull() ?: moviesState.value.firstOrNull()
        hero?.let {
            MovieHero(
                title = it.title,
                posterUrl = it.backdropUrl,
                onDetails = { onMovieClick(it.id) },
                onPlay = { /* no-op for mock */ }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
        SectionTitle(title = "Trending Now")
        LazyRow(modifier = Modifier.padding(start = 12.dp)) {
            items(trendingState.value) { movie ->
                MovieCard(
                    movie = movie,
                    modifier = Modifier.padding(end = 12.dp),
                    onClick = onMovieClick
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        SectionTitle(title = "All Movies")
        LazyRow(modifier = Modifier.padding(start = 12.dp)) {
            items(moviesState.value) { movie ->
                MovieCard(
                    movie = movie,
                    modifier = Modifier.padding(end = 12.dp),
                    onClick = onMovieClick
                )
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    )
}

@Composable
@Preview

fun HomeScreenPreview() {
    val mockViewModel = MovieViewModel()
    Surface {
        HomeScreen(viewModel = mockViewModel, onMovieClick = {})
    }
}
