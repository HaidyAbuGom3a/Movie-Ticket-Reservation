package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.theme.Gray200
import com.example.movie_ticket_reservation.ui.theme.Typography
import com.example.movie_ticket_reservation.ui.ui_states.BookingUiState
import com.example.movie_ticket_reservation.ui.ui_states.DayUiState
import com.example.movie_ticket_reservation.ui.ui_states.TimeUiState

@Composable
fun CardBookingDetails(
    state: BookingUiState,
    onClickTimeItem: (TimeUiState) -> Unit,
    onClickDayItem: (DayUiState) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 500.dp),
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.White)
        ) {
            SpacerVertical24()
            DaysLazyRow(days = state.days, onClickDayItem = onClickDayItem)
            SpacerVertical16()
            TimesLazyRow(times = state.times, onClickTimeItem = onClickTimeItem)
            Spacer(modifier = Modifier.weight(1f))
            Row {
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = stringResource(R.string.dollar) + state.price.toString(),
                        style = Typography.displayLarge
                    )
                    Text(
                        text = state.tickets.toString() + stringResource(R.string.tickets),
                        style = Typography.displaySmall,
                        color = Gray200
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                ButtonPrimary(
                    text = stringResource(R.string.buy_tickets),
                    onClick = { },
                    hasIcon = true,
                    icon = painterResource(id = R.drawable.icon_booking),
                    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
            SpacerVertical24()
        }

    }
}