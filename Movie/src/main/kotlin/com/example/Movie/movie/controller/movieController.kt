package com.example.Movie.movie.controller

import com.example.Movie.movie.domain.Movie
import com.example.Movie.movie.service.movieService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
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

    @GetMapping
    fun d(): ResponseEntity<Unit> {

        return ResponseEntity.ok().build()
    }
}