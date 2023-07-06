package com.example.movie_ticket_reservation.ui.ui_states

data class MoviesUiState(
    val movies:List<MovieUiState> = emptyList()
)

data class MovieUiState(
    val name: String = "",
    val imageUrl: String = "",
    val movieGenre: List<String> = emptyList(),
    val movieTime: String = "",
    val nowShowing: Boolean = false
)