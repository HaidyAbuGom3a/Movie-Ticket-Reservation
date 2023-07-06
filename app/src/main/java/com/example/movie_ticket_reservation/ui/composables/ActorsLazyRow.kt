package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.ui.ui_states.ActorsUiState

@Composable
fun ActorsLazyRow(actors: List<ActorsUiState>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 32.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items = actors, key = { it.actorImageUrl }) {
            ItemActor(actor = it)
        }
    }
}