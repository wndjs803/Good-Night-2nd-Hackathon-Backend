package com.example.Movie.movie.domain

import com.example.Movie.movie.genre.Genre
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Movie(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    @Enumerated(EnumType.STRING)
    val genre: Genre,
    val endDate: LocalDate,
    val screening: Boolean,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
