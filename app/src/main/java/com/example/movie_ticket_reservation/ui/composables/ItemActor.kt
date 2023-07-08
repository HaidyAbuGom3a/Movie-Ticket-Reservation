package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.ui_states.ActorsUiState

@Composable
fun ItemActor(actor: ActorsUiState) {
    Image(
        painter = rememberAsyncImagePainter(
            model = actor.actorImageUrl, placeholder = painterResource(
                id = R.drawable.ic_launcher_background
            )
        ), contentDescription = stringResource(R.string.actor_image),
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .padding(top = 24.dp)
            .size(60.dp)
            .clip(shape = CircleShape)
    )
}
