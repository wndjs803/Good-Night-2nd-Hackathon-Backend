package com.example.Movie.review.controller

import com.example.Movie.movie.domain.Movie
import com.example.Movie.review.domain.Review
import com.example.Movie.review.dto.createMovieRequest
import com.example.Movie.review.dto.createMovieResponse
import com.example.Movie.review.service.reviewService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reviews")
class reviewController(private val reviewService: reviewService){
    @PostMapping
    fun createReview(@RequestBody request: createMovieRequest): ResponseEntity<createMovieResponse>{
        val createdReview = reviewService.createReview(request)
        val response = createMovieResponse(
            content = createdReview!!.content, grade = createdReview.grade, movie = createdReview.movie.title)
        return ResponseEntity.ok(response)
    }

    @GetMapping
    fun findReviews(@RequestParam movieTitle: String): ResponseEntity<List<createMovieResponse>>{
        val findReviews = reviewService.findReviews(movieTitle)
        return ResponseEntity.ok(findReviews)
    }
}