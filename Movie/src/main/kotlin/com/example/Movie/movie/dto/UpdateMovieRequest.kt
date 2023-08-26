package com.example.Movie.movie.dto

import com.example.Movie.movie.genre.Genre
import java.time.LocalDate

data class UpdateMovieRequest(
    var title: String,
    var genre: Genre,
    var openDate: LocalDate,
    var endDate: LocalDate,
    var screening: Boolean
)