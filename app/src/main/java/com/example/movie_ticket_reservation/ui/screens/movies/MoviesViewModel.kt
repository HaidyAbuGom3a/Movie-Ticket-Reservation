package com.example.movie_ticket_reservation.ui.screens.movies

import androidx.lifecycle.ViewModel
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.ui_states.MovieUiState
import com.example.movie_ticket_reservation.ui.ui_states.MoviesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class MoviesViewModel : ViewModel() {
    private val _state = MutableStateFlow(MoviesUiState())
    val state = _state.asStateFlow()

    init {
        getAllMovies()
    }

    private fun getAllMovies() {
        val movies = listOf(
            MovieUiState(
                name = "Morbius",
                imageUrl = "https://pbs.twimg.com/media/FFznqGlVIAEjTfM?format=jpg&name=large",
                imageBlur = R.drawable.image_movie1_blured,
                nowShowing = true,
                movieGenre = listOf("Action", "Adventure", "Horror"),
                movieTime = "1h 44m"
            ),
            MovieUiState(
                name = "Fantastic Beasts: The Secrets of Dumbledore",
                imageUrl = "https://assets.mugglenet.com/wp-content/uploads/2022/02/FMNajsRWYAskvX9.jpg",
                imageBlur = R.drawable.image_movie2_blured,
                nowShowing = true,
                movieGenre = listOf("Fantasy", "Adventure"),
                movieTime = "2h 23m"
            ),
            MovieUiState(
                name = "Doctor Strange in the Multiverse of Madness",
                imageUrl = "https://cdn.kinocheck.com/i/mjcd3f6x6m.jpg",
                imageBlur = R.drawable.image_movie3_blured,
                nowShowing = true,
                movieGenre = listOf("Action","Adventure","Fantasy"),
                movieTime = "2h 6m"
            )
        )
        _state.update { it.copy(movies = movies) }
    }
}