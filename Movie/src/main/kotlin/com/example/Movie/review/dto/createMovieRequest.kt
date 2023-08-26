package com.example.Movie.review.dto

data class createMovieRequest (
    val content: String,
    val grade: Float,
    val id: Long
)