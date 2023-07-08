package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.ui.theme.Gray100
import com.example.movie_ticket_reservation.ui.theme.Gray200
import com.example.movie_ticket_reservation.ui.theme.Typography
import com.example.movie_ticket_reservation.ui.ui_states.TimeUiState

@Composable
fun ItemTime(timeUiState: TimeUiState, onClickTimeItem: (TimeUiState) -> Unit) {
    val cardColor: Color
    val contentColor: Color
    var borderStroke: BorderStroke? = null
    if (timeUiState.isSelected) {
        cardColor = Gray200
        contentColor = Color.White
    } else {
        cardColor = Color.White
        contentColor = Color.Black
        borderStroke = BorderStroke(1.dp, color = Gray100)
    }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = cardColor, contentColor = contentColor
        ),
        border = borderStroke,
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
            .clickable { onClickTimeItem(timeUiState) },
        shape = CircleShape
    ) {
        Text(
            text = timeUiState.time,
            style = Typography.displayMedium,
            modifier = Modifier.padding(8.dp)
        )
    }
}