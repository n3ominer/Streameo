package com.example.streameo.viemodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.streameo.data.model.Movie
import com.example.streameo.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository = MovieRepository()) : ViewModel() {

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    private val _trending = MutableStateFlow<List<Movie>>(emptyList())
    val trending: StateFlow<List<Movie>> = _trending

    private val _selectedMovie = MutableStateFlow<Movie?>(null)
    val selectedMovie: StateFlow<Movie?> = _selectedMovie

    init {
        loadMovies()
    }

    fun loadMovies() {
        viewModelScope.launch {
            _movies.value = repository.getAllMovies()
            _trending.value = repository.getTrendingMovies()
        }
    }

    fun selectMovie(id: String) {
        viewModelScope.launch {
            _selectedMovie.value = repository.getMovieById(id)
        }
    }

    fun clearSelection() {
        _selectedMovie.value = null
    }

    fun moviesByCategory(category: String, onResult: (List<Movie>) -> Unit) {
        viewModelScope.launch {
            onResult(repository.getMoviesByCategory(category))
        }
    }
}
