package com.example.Movie.movie.domain

import com.example.Movie.movie.genre.Genre
import org.hibernate.annotations.UpdateTimestamp
import org.hibernate.annotations.Where
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Where(clause = "IS_DELETED = false")
data class Movie(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var title: String,
    @Enumerated(EnumType.STRING)
    var genre: Genre,
    var openDate: LocalDate,
    var endDate: LocalDate,
    var screening: Boolean,
    var isDeleted: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
){
    fun deleteMovie(){
        this.isDeleted = true
    }

    fun updateMovie(title: String, genre: Genre, openDate: LocalDate, endDate: LocalDate, screening: Boolean){
        this.title = title
        this.genre = genre
        this.openDate = openDate
        this.endDate = endDate
        this.screening = screening
    }


}
