package com.example.Movie.movie.controller

import com.example.Movie.movie.domain.Movie
import com.example.Movie.movie.dto.UpdateMovieRequest
import com.example.Movie.movie.repository.movieRepository
import com.example.Movie.movie.service.movieService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
class movieController(private val movieService: movieService) {

    @PostMapping
    fun creatMovie(@RequestBody movie: Movie): ResponseEntity<Movie> {
        val createdMovie = movieService.createMovie(movie)
        return ResponseEntity.ok(createdMovie)
    }

    @DeleteMapping("{id}")
    fun deleteMovie(@PathVariable id: Long): ResponseEntity<Movie> {
        val deleteMovie = movieService.deleteMovie(id)
        return ResponseEntity.ok(deleteMovie)
    }

    @PutMapping("{id}")
    fun updateMovie(@PathVariable id: Long, @RequestBody request: UpdateMovieRequest): ResponseEntity<Movie> {
        val updateMovie = movieService.updateMovie(id, request)
        return ResponseEntity.ok(updateMovie)
    }
}