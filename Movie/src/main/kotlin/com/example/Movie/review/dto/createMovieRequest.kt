package com.example.Movie.review.dto

data class createMovieRequest (
    val content: String,
    val grade: Int,
    val id: Long
)