package com.example.streameo.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.streameo.ui.components.movie.MovieCard
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import com.example.streameo.viewmodels.MovieViewModel

@Composable
fun BrowseScreen(viewModel: MovieViewModel, onMovieClick: (String) -> Unit) {
    val movies = viewModel.movies.collectAsState()

    val categories = movies.value.flatMap { it.categories }.distinct()

    LazyColumn(modifier = Modifier.fillMaxSize().padding(bottom = 8.dp, top = 8.dp)) {
        items(categories) { category ->
            Text(text = category, modifier = Modifier.padding(16.dp))
            LazyRow(modifier = Modifier.padding(start = 12.dp)) {
                val byCat = movies.value.filter { it.categories.contains(category) }
                items(byCat) { m ->
                    MovieCard(movie = m, modifier = Modifier.padding(end = 12.dp), onClick = onMovieClick)
                }
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Composable
@Preview
fun BrowseScreenPreview() {
    val mockViewModel = MovieViewModel().apply {}
    Surface {
        BrowseScreen(viewModel = mockViewModel, onMovieClick = {})
    }
}