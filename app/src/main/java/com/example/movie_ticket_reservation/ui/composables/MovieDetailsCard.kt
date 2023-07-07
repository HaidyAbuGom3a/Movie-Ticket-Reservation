package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.ui_states.MovieDetailsUiState

@Composable
fun MovieDetailsCard(state: MovieDetailsUiState) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 325.dp),
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MovieDetailsRatings(state)
            TextMovieTitle(
                text = state.name,
                modifier = Modifier.padding(horizontal = 40.dp)
            )
            MovieGenreLazyRow(genres = state.movieGenre)
            ActorsLazyRow(actors = state.actors)
            MovieTextDescription(description = state.description)
            ButtonPrimary(
                text = stringResource(R.string.booking),
                onClick = { },
                hasIcon = true,
                icon = painterResource(id = R.drawable.icon_booking)
            )
            SpacerVertical24()
        }

    }
}