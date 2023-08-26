package com.example.Movie.review.domain

import com.example.Movie.movie.domain.Movie
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Review(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var content: String,
    var grade: Int,
    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    var movie: Movie,
    var isDeleted: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
)
