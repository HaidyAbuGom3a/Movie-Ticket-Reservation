package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.theme.Primary
import com.example.movie_ticket_reservation.ui.theme.Typography
import com.example.movie_ticket_reservation.ui.ui_states.MovieUiState

@Composable
fun CardMovieStatus(state: MovieUiState) {
    val isNowShowing = state.nowShowing
    val cardNowShowingColor: CardColors
    val cardComingSoonColor: CardColors
    var cardNowShowingBorderStroke: BorderStroke? = null
    var cardComingSoonBorderStroke: BorderStroke? = null
    if (isNowShowing) {
        cardNowShowingColor =
            CardDefaults.cardColors(containerColor = Primary, contentColor = Color.White)
        cardComingSoonColor =
            CardDefaults.cardColors(containerColor = Color.Transparent, contentColor = Color.White)
        cardComingSoonBorderStroke = BorderStroke(1.dp, color = Color.White)
    } else {
        cardComingSoonColor =
            CardDefaults.cardColors(containerColor = Primary, contentColor = Color.White)
        cardNowShowingColor =
            CardDefaults.cardColors(containerColor = Color.Transparent, contentColor = Color.White)
        cardNowShowingBorderStroke = BorderStroke(1.dp, color = Color.White)
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
    ) {
        Card(
            colors = cardNowShowingColor,
            shape = RoundedCornerShape(24.dp),
            border = cardNowShowingBorderStroke
        ) {
            Text(
                text = stringResource(R.string.now_showing),
                style = Typography.displayMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Card(
            colors = cardComingSoonColor,
            shape = RoundedCornerShape(24.dp),
            border = cardComingSoonBorderStroke
        ) {
            Text(
                text = stringResource(R.string.coming_soon),
                style = Typography.displayMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}