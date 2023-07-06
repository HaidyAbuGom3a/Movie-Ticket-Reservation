package com.example.movie_ticket_reservation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.composables.CardClose
import com.example.movie_ticket_reservation.ui.composables.CardMovieTime
import com.example.movie_ticket_reservation.ui.composables.CardPlay
import com.example.movie_ticket_reservation.ui.composables.ItemVideo
import com.example.movie_ticket_reservation.ui.composables.MovieDetailsCard
import com.example.movie_ticket_reservation.ui.screens.movie_details.MovieDetailsViewModel
import com.example.movie_ticket_reservation.ui.theme.Primary
import com.example.movie_ticket_reservation.ui.ui_states.MovieDetailsUiState

@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    MovieDetailsContent(state)
}


@Composable
fun MovieDetailsContent(state: MovieDetailsUiState) {
    Box {
        ItemVideo(state = state)
        MovieDetailsCard(state = state)
    }
}


@Preview(showSystemUi = true)
@Composable
fun preview() {
    val viewModel: MovieDetailsViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    MovieDetailsContent(state)
}