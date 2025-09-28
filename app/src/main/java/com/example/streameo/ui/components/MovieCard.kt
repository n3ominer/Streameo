package com.example.streameo.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import androidx.compose.ui.unit.dp
import com.example.streameo.data.model.Movie

@Composable
fun MovieCard(movie: Movie, modifier: Modifier = Modifier, onClick: (String) -> Unit = {}) {
    Column(
        modifier = modifier
            .width(120.dp)
            .clickable { onClick(movie.id) }
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .height(170.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = movie.title,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = movie.title, maxLines = 2, style = MaterialTheme.typography.bodyMedium)
        Text(text = "${movie.year}", style = MaterialTheme.typography.labelSmall)
    }
}


@Composable
@Preview
fun MovieCardPreview() {
    val sampleMovie = Movie(
        id = "sample_id",
        title = "Sample Movie",
        year = 2025,
        rating = "PG-13",
        duration = "2h00",
        matchPercent = 95,
        overview = "This is a sample movie used for previewing the MovieCard component.",
        posterUrl = "https://picsum.photos/id/1005/500/750",
        backdropUrl = "https://picsum.photos/id/1015/1200/700",
        topCast = listOf("Actor A", "Actor B"),
        isTrending = true,
        categories = listOf("Action", "Adventure")
    )

    MovieCard(movie = sampleMovie, onClick = {})
}