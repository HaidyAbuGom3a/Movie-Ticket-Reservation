package com.example.movie_ticket_reservation.ui.screens.booking

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.composables.CardBookingDetails
import com.example.movie_ticket_reservation.ui.composables.CardClose
import com.example.movie_ticket_reservation.ui.composables.RowSeatsAvailability
import com.example.movie_ticket_reservation.ui.composables.SeatsLazyGrid
import com.example.movie_ticket_reservation.ui.ui_states.BookingUiState
import com.example.movie_ticket_reservation.ui.ui_states.DayUiState
import com.example.movie_ticket_reservation.ui.ui_states.TimeUiState

@Composable
fun BookingScreen(
    navController: NavController,
    viewModel: BookingViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val message = stringResource(R.string.done_successfully)
    val context = LocalContext.current
    BookingContent(
        state,
        viewModel::onClickSeat,
        viewModel::onClickDayItem,
        viewModel::onClickTimeItem,
        { navController.navigateUp() }
    ) { Toast.makeText(context, message, Toast.LENGTH_SHORT).show() }
}


@Composable
fun BookingContent(
    state: BookingUiState,
    onClickSeat: (Boolean, Int) -> Unit,
    onClickDayItem: (DayUiState) -> Unit,
    onClickTimeItem: (TimeUiState) -> Unit,
    onClickBackButton: () -> Unit,
    onClickBuyTickets: () -> Unit
) {
    Box {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .height(530.dp)
                .fillMaxWidth(),
            shape = RectangleShape
        ) {
            Column {
                CardClose(onClickBackButton)
                Image(
                    painter = painterResource(R.drawable.image_cinema),
                    contentDescription = stringResource(R.string.cinema_screen),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
                SeatsLazyGrid(state = state, onClickSeat = onClickSeat)
                RowSeatsAvailability()
            }
        }
        CardBookingDetails(
            state = state,
            onClickTimeItem = onClickTimeItem,
            onClickDayItem = onClickDayItem,
            onClickBuyTickets = onClickBuyTickets
        )

    }
}


//@Composable
//@Preview(showSystemUi = true)
//fun previewBookingScreen() {
//    val viewModel: BookingViewModel = hiltViewModel()
//    BookingScreen(viewModel)
//}