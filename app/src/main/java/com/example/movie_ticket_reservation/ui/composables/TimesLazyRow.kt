package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.ui.ui_states.TimeUiState

@Composable
fun TimesLazyRow(times: List<TimeUiState>, onClickTimeItem: (TimeUiState) -> Unit) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(times) {
            ItemTime(timeUiState = it, onClickTimeItem)
        }
    }
}