package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.theme.Gray400
import com.example.movie_ticket_reservation.ui.theme.Primary

@Composable
fun RowSeatsAvailability(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        ItemSeatAvailability(
            text = stringResource(R.string.available),
            color = Color.White
        )
        ItemSeatAvailability(text = stringResource(R.string.taken), color = Gray400)
        ItemSeatAvailability(text = stringResource(R.string.selected), color = Primary)
    }
}