package com.example.Movie.movie.service

import com.example.Movie.movie.domain.Movie
import com.example.Movie.movie.repository.movieRepository
import org.springframework.stereotype.Service

@Service
class movieService(private val movieRepository: movieRepository) {
    fun createMovie(movie: Movie): Movie {
        return movieRepository.save(movie)
    }

    fun deleteMovie(id: Long): Movie {
        val movie = movieRepository.findById(id)
        val findMovie = movie.get()
        findMovie.isDeleted = true

        movieRepository.save(findMovie)

        return findMovie
    }
}