package com.example.Movie.movie.repository

import com.example.Movie.movie.domain.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface movieRepository : JpaRepository<Movie, Long>