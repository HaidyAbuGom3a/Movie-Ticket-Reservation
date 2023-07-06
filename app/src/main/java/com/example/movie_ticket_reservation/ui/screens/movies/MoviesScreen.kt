package com.example.movie_ticket_reservation.ui.screens.movies

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movie_ticket_reservation.ui.ui_states.MoviesUiState

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    MoviesContent(state)
}

@Composable
fun MoviesContent(
    state: MoviesUiState
) {

}

@Preview(showSystemUi = true)
@Composable
fun previewMoviesScreen() {
    val viewModel: MoviesViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    MoviesContent(state = state)
}
