package com.example.Movie.movie.domain

import com.example.Movie.movie.genre.Genre
import org.springframework.web.bind.annotation.PathVariable
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Movie(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var title: String,
    @Enumerated(EnumType.STRING)
    var genre: Genre,
    var endDate: LocalDate,
    var isDeleted: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now()
){
    fun deleteMovie(){
        this.isDeleted = true
    }
}
