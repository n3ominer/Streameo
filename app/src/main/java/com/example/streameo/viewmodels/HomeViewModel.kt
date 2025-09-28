package com.example.streameo.viewmodels

import androidx.lifecycle.ViewModel
import com.example.streameo.MovieRepository
import com.example.streameo.data.Movie

class HomeViewModel(private val repository: MovieRepository) : ViewModel() {
    val featured: Movie = repository.getFeaturedMovie()
    val trending: List<Movie> = repository.getTrending()
    val series: List<Movie> = repository.getSeries()
    val koreanDramas: List<Movie> = repository.getKoreanDramas()
}