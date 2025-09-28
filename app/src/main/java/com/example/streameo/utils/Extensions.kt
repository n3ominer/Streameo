package com.example.streameo.utils

import androidx.compose.ui.unit.dp

/**
 * Extension functions and utilities for Compose UI
 */

/**
 * Convert Int to dp
 */
val Int.dp get() = this.dp

/**
 * Safely get string or return empty string
 */
fun String?.orEmpty(): String = this ?: ""

/**
 * Format duration string
 */
fun String.formatDuration(): String {
    return this.replace("h", "h ").replace("min", " min")
}