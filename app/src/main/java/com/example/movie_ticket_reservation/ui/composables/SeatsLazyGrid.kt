package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.ui.ui_states.BookingUiState

@Composable
fun SeatsLazyGrid(state: BookingUiState, onClickSeat: (Boolean, Int) -> Unit) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(state.seats) { index, item ->
            if (index % 3 == 0) {
                ItemTwoSeats(
                    seats = item,
                    modifier = Modifier.rotate(8f),
                    onClickSeat = onClickSeat,
                    index = index
                )

            } else if (index % 3 == 1) {
                ItemTwoSeats(seats = item, onClickSeat = onClickSeat, index = index)
            } else {
                ItemTwoSeats(
                    seats = item,
                    modifier = Modifier.rotate(-8f),
                    onClickSeat = onClickSeat,
                    index = index
                )
            }
        }
    }

}