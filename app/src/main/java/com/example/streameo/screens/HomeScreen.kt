package com.example.streameo.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.streameo.ui.components.movie.MovieCard
import com.example.streameo.viewmodels.MovieViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.streameo.ui.components.home_components.FullImageWithFade
import com.example.streameo.ui.components.home_components.HomeCustomTopBar
import com.example.streameo.ui.components.common.SectionTitle

@Composable
fun HomeScreen(viewModel: MovieViewModel, onMovieClick: (String) -> Unit) {
    val moviesState = viewModel.movies.collectAsState()
    val trendingState = viewModel.trending.collectAsState()
    val listState = rememberLazyListState()

    val hero = trendingState.value.firstOrNull() ?: moviesState.value.firstOrNull()

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                hero?.let {
                    val scrollOffset = listState.firstVisibleItemScrollOffset.toFloat()
                    val alpha = (1f - scrollOffset / 500f).coerceIn(0f, 1f)

                    Box(contentAlignment = Alignment.BottomCenter) {
                        FullImageWithFade(
                            imageUrl = it.posterUrl,
                            content = {},
                            alpha = alpha
                        )

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                            Text(it.title, fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.White)

                            Spacer(modifier = Modifier.height(24.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 48.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Button(
                                    onClick = { },
                                    modifier = Modifier.weight(1f),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Red,
                                        contentColor = Color.White
                                    )
                                ) {
                                    Icon(
                                        Icons.Filled.PlayArrow,
                                        contentDescription = "Search",
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("Play")
                                }
                                Spacer(modifier = Modifier.width(12.dp))

                                Button(
                                    onClick = { },
                                    modifier = Modifier.weight(1f),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Red,
                                        contentColor = Color.White
                                    )
                                ) {
                                    Text("Details")
                                }
                            }
                        }
                    }

                }
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }


            // Section Trending movies
            item { SectionTitle(title = "Trending Now") }

            item {
                LazyRow(modifier = Modifier.padding(start = 12.dp)) {
                    items(trendingState.value) { movie ->
                        MovieCard(
                            movie = movie,
                            modifier = Modifier.padding(end = 12.dp),
                            onClick = onMovieClick
                        )
                    }
                }
            }


            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Section All Movies
            item { SectionTitle(title = "All Movies") }

            item {
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

            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Section All Movies
            item { SectionTitle(title = "All Movies") }

            item {
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

            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Section All Movies
            item { SectionTitle(title = "All Movies") }

            item {
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

            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Section All Movies
            item { SectionTitle(title = "All Movies") }

            item {
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

            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Section All Movies
            item { SectionTitle(title = "All Movies") }

            item {
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

        HomeCustomTopBar()
    }
}
