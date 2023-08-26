package com.example.Movie.movie.service

import com.example.Movie.movie.domain.Movie
import com.example.Movie.movie.repository.movieRepository
import org.springframework.stereotype.Service

@Service
class movieService(private val movieRepository: movieRepository) {
    fun createMovie(movie: Movie): Movie {
        return movieRepository.save(movie)
    }
}