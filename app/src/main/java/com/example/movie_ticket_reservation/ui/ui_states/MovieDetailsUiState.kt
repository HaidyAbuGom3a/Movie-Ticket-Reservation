package com.example.movie_ticket_reservation.ui.ui_states

data class MovieDetailsUiState(
    val name: String = "",
    val imageUrl: String = "",
    val description: String = "",
    val IMDbRate: String = "",
    val rottenTomatoesRate: String = "",
    val IGNRate: String = "",
    val actors: List<ActorsUiState> = emptyList(),
    val movieGenre: List<String> = emptyList(),
    val movieTime: String = ""
)

data class ActorsUiState(
    val actorImageUrl: String
)