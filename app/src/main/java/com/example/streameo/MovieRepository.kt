package com.example.streameo

import com.example.streameo.data.Cast
import com.example.streameo.data.Movie

class MovieRepository {
    fun getFeaturedMovie(): Movie = Movie(
        id = 1,
        title = "John Wick",
        posterUrl = "https://image.tmdb.org/t/p/w500/vZloFAK7NmvMGKE7VkF5UHaz0I.jpg",
        backgroundUrl = "https://image.tmdb.org/t/p/original/hT3jNhh1Vi14rX9UbN4mznIbRYI.jpg",
        description = "John Wick uncovers a path to defeating The High Table. But before he can earn his freedom, Wick must face off against a new enemy with powerful alliances across the globe and forces that turn old friends into foes.",
        year = 2023,
        duration = "2h 49m",
        rating = "R",
        match = 95,
        cast = listOf(
            Cast("Keanu Reeves", "John Wick", "https://image.tmdb.org/t/p/w500/4COE6aNLbz3Hah3rLe7MpyQzQnO.jpg"),
            Cast("Laurence Fishburne", "Bowery King", "https://image.tmdb.org/t/p/w500/8suOhUmPbfnIm1pQCdYnHUTKt6r.jpg"),
            Cast("George Georgiou", "The Elder", "https://image.tmdb.org/t/p/w500/8mI2C3lpWt3JUXoCpxeCM3b8yLq.jpg"),
            Cast("Bill Skarsgård", "Marquis", "https://image.tmdb.org/t/p/w500/iQ2RyYqCBWZXFkzbXolazulxdp2.jpg")
        )
    )

    fun getTrending(): List<Movie> = listOf(
        Movie(2, "The Glory", "https://image.tmdb.org/t/p/w500/clB7wgLuWigqO7TfSmZHtLnT9uA.jpg", description = "Years after surviving horrific abuse in high school, a woman puts an elaborate revenge scheme in motion.", year = 2022, duration = "50m", rating = "TV-MA"),
        Movie(3, "Arcane", "https://image.tmdb.org/t/p/w500/rqeAiMpeASO3JUoPixdK0Iopka.jpg", description = "Amid the stark discord of twin cities Piltover and Zaun, two sisters fight on rival sides of a war.", year = 2021, duration = "40m", rating = "TV-14"),
        Movie(4, "Peaky Blinders", "https://image.tmdb.org/t/p/w500/vUYfyyiCuHYG2Z5oXwTubCqhN10.jpg", description = "A gangster family epic set in 1900s England, centering on a gang who sew razor blades in the peaks of their caps.", year = 2013, duration = "60m", rating = "TV-MA")
    )

    fun getSeries(): List<Movie> = listOf(
        Movie(5, "Breaking Bad", "https://image.tmdb.org/t/p/w500/3xnWaLQcb8GtvvCqe1U11UL0C1D.jpg", description = "A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine.", year = 2008, duration = "45m", rating = "TV-MA"),
        Movie(6, "You", "https://image.tmdb.org/t/p/w500/7Dktk2ST6iiJdS8N05W8vRmYpXq.jpg", description = "A dangerously charming, intensely obsessive young man goes to extreme measures to insert himself into the lives of those he is transfixed by.", year = 2018, duration = "45m", rating = "TV-MA"),
        Movie(7, "Narcos", "https://image.tmdb.org/t/p/w500/sROhwBMK0cQFYV5X7Vbz8GhtMV9.jpg", description = "A gritty chronicle of the war against Colombia's infamously violent and powerful drug cartels.", year = 2015, duration = "57m", rating = "TV-MA")
    )

    // Placeholder for Korean TV Drama section (based on mockup visuals; assumed popular shows)
    fun getKoreanDramas(): List<Movie> = listOf(
        Movie(8, "All of Us Are Dead", "https://image.tmdb.org/t/p/w500/mGVrXeIjy0K2mKpa0HA1D7HNT4v.jpg", description = "A high school becomes ground zero for a zombie virus outbreak.", year = 2022, duration = "60m", rating = "TV-MA"),
        Movie(9, "Squid Game", "https://image.tmdb.org/t/p/w500/dDlEmu3EZ0Pgg93K2SVNLCjCSvE.jpg", description = "Hundreds of cash-strapped players accept a strange invitation to compete in children's games.", year = 2021, duration = "55m", rating = "TV-MA"),
        Movie(10, "Vincenzo", "https://image.tmdb.org/t/p/w500/dvCh4chH9VRor8nEwm3lpAlE2Ep.jpg", description = "During a visit to his motherland, a Korean-Italian mafia lawyer gives an unrivaled conglomerate a taste of its own medicine.", year = 2021, duration = "80m", rating = "TV-14")
    )

    fun getMovieById(id: Int): Movie? {
        return (listOf(getFeaturedMovie()) + getTrending() + getSeries() + getKoreanDramas()).find { it.id == id }
    }
}