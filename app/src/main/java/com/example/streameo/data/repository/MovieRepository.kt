package com.example.streameo.data.repository

import com.example.streameo.data.mock.MockMovieData
import com.example.streameo.data.model.Movie
import kotlinx.coroutines.delay

class MovieRepository {

    // Simule une source locale / DB
    private val movies = MockMovieData.movies

    suspend fun getAllMovies(): List<Movie> {
        // simulate small delay
        delay(200)
        return movies
    }

    suspend fun getTrendingMovies(): List<Movie> {
        delay(150)
        return movies.filter { it.isTrending }
    }

    suspend fun getMovieById(id: String): Movie? {
        delay(100)
        return movies.firstOrNull { it.id == id }
    }

    suspend fun getMoviesByCategory(category: String): List<Movie> {
        delay(150)
        return movies.filter { it.categories.contains(category) }
    }
}