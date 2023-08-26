package com.example.Movie.movie.service

import com.example.Movie.movie.domain.Movie
import com.example.Movie.movie.dto.UpdateMovieRequest
import com.example.Movie.movie.genre.Genre
import com.example.Movie.movie.repository.movieRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
@Transactional
class movieService(private val movieRepository: movieRepository) {
    fun createMovie(movie: Movie): Movie {
        return movieRepository.save(movie)
    }

    fun deleteMovie(id: Long): Movie {
        val movie = movieRepository.findById(id)
        val findMovie = movie.get()

        findMovie.deleteMovie()

        movieRepository.save(findMovie)

        return findMovie
    }

    fun updateMovie(id: Long, request: UpdateMovieRequest): Movie{
        val movie = movieRepository.findById(id)
        val updateMovie = movie.get()

        updateMovie.updateMovie(request.title, request.genre, request.openDate, request.endDate, request.screening)

        movieRepository.save(updateMovie)

        return updateMovie
    }

    fun findMovie(id: Long): UpdateMovieRequest? {
        val movie = movieRepository.findById(id)
        if(movie.isEmpty) return null
        val findMovie = movie.get()
        if (findMovie.isDeleted) return null
        return UpdateMovieRequest(
            title = findMovie.title,
            genre = findMovie.genre,
            openDate = findMovie.openDate,
            endDate = findMovie.endDate,
            screening = findMovie.screening
        )
    }

    fun findMoviesByGenreAndScreening(genre: Genre?, screening: Boolean?): List<UpdateMovieRequest> {
        val movies = movieRepository.findAll(Sort.by(Sort.Direction.ASC, "openDate"))

        val filteredMovies = ArrayList<UpdateMovieRequest>()
        for (movie in movies){
            if(movie.genre == genre && movie.screening == screening) {
                val filterMovie = UpdateMovieRequest(
                    title = movie.title,
                    genre = movie.genre,
                    openDate = movie.openDate,
                    endDate = movie.endDate,
                    screening = movie.screening
                )
                filteredMovies.add(filterMovie)
            }
            else if ((movie.genre == null || movie.genre == genre) || (movie.screening == null || movie.screening == screening)) {
                val filterMovie = UpdateMovieRequest(
                    title = movie.title,
                    genre = movie.genre,
                    openDate = movie.openDate,
                    endDate = movie.endDate,
                    screening = movie.screening
                )
                filteredMovies.add(filterMovie)
            }
        }
        return filteredMovies
    }
}