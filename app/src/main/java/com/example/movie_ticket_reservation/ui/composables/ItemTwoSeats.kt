package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.theme.Gray400
import com.example.movie_ticket_reservation.ui.theme.Primary
import com.example.movie_ticket_reservation.ui.theme.PrimaryDark
import com.example.movie_ticket_reservation.ui.ui_states.AvailabilityType
import com.example.movie_ticket_reservation.ui.ui_states.SeatsUiState

@Composable
fun ItemTwoSeats(
    seats: SeatsUiState,
    modifier: Modifier = Modifier,
    onClickSeat: (Boolean, Int) -> Unit,
    index: Int
) {
    val firstSeatColor: Color = getSeatColor(seats.firstSeatAvailability)
    val secondSeatColor: Color = getSeatColor(seats.secondSeatAvailability)
    val containerColor: Color =
        if (firstSeatColor == Primary && secondSeatColor == Primary) PrimaryDark
        else Gray400

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Icon(
            painter = painterResource(id = R.drawable.icon_chair_container),
            contentDescription = "",
            tint = containerColor
        )
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.icon_chair),
                contentDescription = "", tint = firstSeatColor,
                modifier = Modifier.clickable { onClickSeat(true, index) }
            )
            Icon(
                painter = painterResource(id = R.drawable.icon_chair),
                contentDescription = "", tint = secondSeatColor,
                modifier = Modifier.clickable { onClickSeat(false, index) }
            )
        }
    }
}

fun getSeatColor(availabilityType: AvailabilityType) =
    when (availabilityType) {
        AvailabilityType.AVAILABLE -> Color.White
        AvailabilityType.TAKEN -> Gray400
        AvailabilityType.SELECTED -> Primary
    }