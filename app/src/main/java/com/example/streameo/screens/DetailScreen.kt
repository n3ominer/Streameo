package com.example.streameo.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import com.example.streameo.data.model.Movie
import coil.compose.AsyncImage
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.streameo.ui.components.common.BlurryIconButton

@Composable
fun DetailScreen(movie: Movie?, onBack: () -> Unit) {
    if (movie == null) {
        Text("Film introuvable")
        return
    }
    Surface(modifier = Modifier.padding(top = 12.dp)) {
        Box {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(12.dp))

                // Movie poster and details
                Column {
                    AsyncImage(
                        model = movie.posterUrl,
                        contentDescription = movie.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "${movie.matchPercent}% match",
                            maxLines = 1,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF43A047)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            "${movie.year} • ${movie.duration} • ${movie.rating}",
                            style = MaterialTheme.typography.bodySmall,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.LightGray
                        )
                    }
                }

                Button(
                    onClick = { /* Gestion de la lecture de l'extrait*/},
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
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

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    "Prolog",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = movie.overview,
                    modifier = Modifier.padding(16.dp),
                    maxLines = 30,
                    style = MaterialTheme.typography.bodySmall,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.LightGray
                )

                Text(
                    "Top Cast",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                LazyRow(modifier = Modifier.padding(start = 12.dp)) {
                    items(movie.topCast) { cast ->
                        Surface(modifier = Modifier.padding(end = 12.dp), shape = CircleShape) {
                            Column(
                                modifier = Modifier.padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                // Placeholder avatar
                                Surface(
                                    modifier = Modifier.size(64.dp),
                                    shape = CircleShape
                                ) {
                                    AsyncImage(
                                        model = "https://picsum.photos/seed/${cast.hashCode()}/64/64",
                                        contentDescription = cast
                                    )
                                }
                                Text(
                                    cast,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.width(70.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Top bar with blurred background
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp).padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                BlurryIconButton(Icons.Filled.ArrowBack, onClick = onBack)

                BlurryIconButton(Icons.Filled.MoreVert, onClick = { /* TODO: search action */ })
            }

        }
    }
}


@Composable
@Preview
fun DetailScreenPreview() {
    val sampleMovie = Movie(
        id = "sample_id",
        title = "Sample Movie",
        year = 2025,
        rating = "PG-13",
        duration = "2h00",
        matchPercent = 95,
        overview = "This is a sample movie used for previewing the DetailScreen component. It has a longer description to test text overflow handling in the UI layout.",
        posterUrl = "https://picsum.photos/id/1005/500/750",
        backdropUrl = "https://picsum.photos/id/1015/1200/700",
        topCast = listOf("Actor A", "Actor B", "Actor C", "Actor D"),
        isTrending = true,
        categories = listOf("Action", "Adventure")
    )

    Surface {
        DetailScreen(movie = sampleMovie, onBack = {})
    }
}
