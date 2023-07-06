package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.ui_states.MovieDetailsUiState

@Composable
fun ItemVideo(state: MovieDetailsUiState) {
    Box {
        Image(
            painter = rememberAsyncImagePainter(
                model = state.imageUrl, placeholder = painterResource(
                    id = R.drawable.ic_launcher_background
                )
            ),
            contentDescription = stringResource(R.string.movie_image_content_description),
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            contentScale = ContentScale.FillWidth
        )
        Row {
            CardClose()
            Spacer(Modifier.weight(1f))
            CardMovieTime(time = state.movieTime)
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth()
        ) {
            CardPlay()
        }

    }
}