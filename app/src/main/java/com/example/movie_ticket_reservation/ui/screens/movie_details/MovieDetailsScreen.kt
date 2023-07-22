package com.example.movie_ticket_reservation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.movie_ticket_reservation.ui.composables.ItemVideo
import com.example.movie_ticket_reservation.ui.composables.MovieDetailsCard
import com.example.movie_ticket_reservation.ui.screens.booking.navigateToBooking
import com.example.movie_ticket_reservation.ui.screens.movie_details.MovieDetailsViewModel
import com.example.movie_ticket_reservation.ui.ui_states.MovieDetailsUiState

@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    MovieDetailsContent(state, { navController.navigateUp() }) { navController.navigateToBooking() }
}


@Composable
fun MovieDetailsContent(
    state: MovieDetailsUiState,
    onClickClose: () -> Unit,
    onClickBooking: () -> Unit
) {
    Box {
        ItemVideo(state = state, onClickClose)
        MovieDetailsCard(state = state, onClickBooking)
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun preview() {
//    val viewModel: MovieDetailsViewModel = hiltViewModel()
//    val state by viewModel.state.collectAsState()
//    MovieDetailsContent(state)
//}