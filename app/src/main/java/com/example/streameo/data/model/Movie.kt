package com.example.streameo.data.model

data class Movie(
    val id: String,
    val title: String,
    val year: Int,
    val rating: String,
    val duration: String,
    val matchPercent: Int,
    val overview: String,
    val posterUrl: String,
    val backdropUrl: String,
    val topCast: List<String>,
    val isTrending: Boolean = false,
    val categories: List<String> = emptyList()
)