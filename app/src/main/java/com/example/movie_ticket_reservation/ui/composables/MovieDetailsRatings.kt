package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.ui_states.MovieDetailsUiState

@Composable
fun MovieDetailsRatings(state: MovieDetailsUiState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .padding(top = 32.dp, bottom = 24.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ItemRate(state.IMDbRate, stringResource(R.string.imdb), false)
        ItemRate(
            rate = state.rottenTomatoesRate,
            websiteName = stringResource(R.string.rotten_tomatoes),
            isPercent = true
        )
        ItemRate(
            rate = state.IGNRate,
            websiteName = stringResource(R.string.ign),
            isPercent = false
        )
    }
}