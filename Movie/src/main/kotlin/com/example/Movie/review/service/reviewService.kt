package com.example.Movie.review.service

import com.example.Movie.movie.domain.Movie
import com.example.Movie.movie.repository.movieRepository
import com.example.Movie.review.domain.Review
import com.example.Movie.review.dto.createMovieRequest
import com.example.Movie.review.dto.createMovieResponse
import com.example.Movie.review.repository.reviewRepository
import org.hibernate.type.StringNVarcharType
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class reviewService(val reviewRepository: reviewRepository, val movieRepository: movieRepository) {

    fun createReview(request: createMovieRequest): Review?{
        val movie = movieRepository.findById(request.id)
        var findMovie: Movie? = null
        if(movie.isPresent){
            findMovie = movie.get()
        }
        else return null
        val review = Review(content = request.content, grade = request.grade, movie = findMovie)

        reviewRepository.save(review)
        return review
    }

    fun findReviews(movieTitle: String): List<createMovieResponse>{
        val reviews = reviewRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"))

        val filteredReviews = ArrayList<createMovieResponse>()

        for(review in reviews){
            if(review.movie.title == movieTitle){
                filteredReviews.add(
                    createMovieResponse(
                        content = review.content,
                        grade = review.grade,
                        movie = movieTitle
                    )
                )
            }
        }

        return filteredReviews
    }
}