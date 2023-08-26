package com.example.Movie.review.repository

import com.example.Movie.review.domain.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface reviewRepository : JpaRepository<Review, Long>