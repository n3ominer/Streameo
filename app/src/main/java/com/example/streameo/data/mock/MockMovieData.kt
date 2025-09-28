package com.example.streameo.data.mock


import com.example.streameo.data.model.Movie

object MockMovieData {

    // Note: j'ai mis des URLs publiques (picsum.photos / unsplash) comme placeholders.
    // Remplace-les par des posters officiels 2025 si besoin.
    val movies = listOf(
        Movie(
            id = "tron_ares",
            title = "TRON: Ares",
            year = 2025,
            rating = "PG-13",
            duration = "1h59",
            matchPercent = 92,
            overview = "Ares, a sophisticated program, is sent from the Grid into the real world...",
            posterUrl = "https://picsum.photos/id/1005/500/750", // placeholder
            backdropUrl = "https://picsum.photos/id/1015/1200/700",
            topCast = listOf("Jared Leto", "Greta Lee", "Evan Peters"),
            isTrending = true,
            categories = listOf("Sci-Fi", "Action")
        ),
        Movie(
            id = "28_years_later",
            title = "28 Years Later",
            year = 2025,
            rating = "R",
            duration = "2h03",
            matchPercent = 87,
            overview = "A visceral continuation that explores the aftermath of the rage virus years later.",
            posterUrl = "https://picsum.photos/id/1011/500/750",
            backdropUrl = "https://picsum.photos/id/1016/1200/700",
            topCast = listOf("Actor A", "Actor B"),
            isTrending = true,
            categories = listOf("Horror", "Thriller")
        ),
        Movie(
            id = "predator_badlands",
            title = "Predator: Badlands",
            year = 2025,
            rating = "R",
            duration = "1h55",
            matchPercent = 81,
            overview = "A remote outpost faces the return of a deadly hunter from beyond the stars.",
            posterUrl = "https://picsum.photos/id/1018/500/750",
            backdropUrl = "https://picsum.photos/id/1020/1200/700",
            topCast = listOf("Actor C", "Actor D"),
            categories = listOf("Action", "Sci-Fi")
        ),
        Movie(
            id = "chainsaw_reze",
            title = "Chainsaw Man — Reze Arc",
            year = 2025,
            rating = "R",
            duration = "2h10",
            matchPercent = 89,
            overview = "The Reze arc adapted for the big screen: violence, pathos and surreal imagery.",
            posterUrl = "https://picsum.photos/id/1025/500/750",
            backdropUrl = "https://picsum.photos/id/1026/1200/700",
            topCast = listOf("Voice A", "Voice B"),
            isTrending = false,
            categories = listOf("Anime", "Action")
        ),
        Movie(
            id = "superman_2025",
            title = "Superman",
            year = 2025,
            rating = "PG-13",
            duration = "2h12",
            matchPercent = 75,
            overview = "A fresh take on the Last Son of Krypton dealing with identity and responsibility.",
            posterUrl = "https://picsum.photos/id/1031/500/750",
            backdropUrl = "https://picsum.photos/id/1035/1200/700",
            topCast = listOf("Actor E", "Actor F"),
            isTrending = false,
            categories = listOf("Action", "Adventure")
        )
    )
}
