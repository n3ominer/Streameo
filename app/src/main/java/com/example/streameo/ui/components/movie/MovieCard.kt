package com.example.streameo.ui.components.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.streameo.data.model.Movie
import com.example.streameo.utils.Constants

/**
 * Movie card component for displaying movie information
 */
@Composable
fun MovieCard(
    movie: Movie,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {}
) {
    Column(
        modifier = modifier
            .width(Constants.MOVIE_CARD_WIDTH.dp)
            .clickable { onClick(movie.id) }
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .height(Constants.MOVIE_CARD_HEIGHT.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = movie.title,
                modifier = Modifier.fillMaxSize()
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = movie.title,
            maxLines = 2,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
        
        Text(
            text = "${movie.year}",
            style = MaterialTheme.typography.labelSmall,
            color = Color.White
        )
    }
}

@Preview
@Composable
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