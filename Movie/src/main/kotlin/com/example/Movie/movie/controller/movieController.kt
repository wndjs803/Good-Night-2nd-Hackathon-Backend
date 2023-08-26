package com.example.Movie.movie.controller

import com.example.Movie.movie.domain.Movie
import com.example.Movie.movie.dto.UpdateMovieRequest
import com.example.Movie.movie.genre.Genre
import com.example.Movie.movie.service.movieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @GetMapping("{id}")
    fun findMovie(@PathVariable id: Long): Any {
        val findMovie = movieService.findMovie(id)
        return if (findMovie != null) {
            ResponseEntity.ok(findMovie)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(mapOf("message" to "Movie not found"))
        }
    }

    @GetMapping
    fun findMoviesByGenreAndScreening(@RequestParam(required = false) genre: Genre?, @RequestParam(required = false) screening: Boolean?,): ResponseEntity<List<UpdateMovieRequest>>{
        val findMovies = movieService.findMoviesByGenreAndScreening(genre, screening)

        return ResponseEntity.ok(findMovies)
    }
}