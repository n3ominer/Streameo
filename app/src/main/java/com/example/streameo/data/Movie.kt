package com.example.streameo.data

data class Movie(
    val id: Int,
    val title: String,
    val posterUrl: String,
    val backgroundUrl: String? = null,
    val description: String,
    val year: Int,
    val duration: String,
    val rating: String,
    val match: Int? = null,
    val cast: List<Cast> = emptyList()
)