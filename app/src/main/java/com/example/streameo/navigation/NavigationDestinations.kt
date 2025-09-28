package com.example.streameo.navigation

/**
 * Navigation destinations for the Streameo app
 */
object NavigationDestinations {
    const val HOME = "home"
    const val SEARCH = "search"
    const val PROFILE = "profile"
    const val DETAIL = "detail/{movieId}"
    
    /**
     * Helper function to create detail route with movieId
     */
    fun createDetailRoute(movieId: String): String = "detail/$movieId"
    
    /**
     * Route arguments
     */
    object Args {
        const val MOVIE_ID = "movieId"
    }
}