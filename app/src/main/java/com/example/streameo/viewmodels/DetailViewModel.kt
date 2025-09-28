package com.example.streameo.viewmodels

import androidx.lifecycle.ViewModel
import com.example.streameo.MovieRepository
import com.example.streameo.data.Movie

class DetailViewModel(private val repository: MovieRepository, val movieId: Int) : ViewModel() {
    val movie: Movie? = repository.getMovieById(movieId)
}