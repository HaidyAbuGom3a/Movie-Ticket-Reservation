package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.movie_ticket_reservation.ui.ui_states.DayUiState

@Composable
fun ItemDay(day: DayUiState, onClickDayItem: (DayUiState) -> Unit) {
    val cardColor: Color
    val firstTextColor: Color
    val secondTextColor: Color
    var borderStroke: BorderStroke? = null
    if (day.isSelected) {
        cardColor = Gray200
        firstTextColor = Color.White
        secondTextColor = Gray100
    } else {
        cardColor = Color.White
        firstTextColor = Color.Black
        secondTextColor = Gray200
        borderStroke = BorderStroke(1.dp, color = Gray100)
    }
    Card(
        modifier = Modifier
            .height(65.dp)
            .width(55.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        border = borderStroke
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .clickable { onClickDayItem(day) },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = day.dayNum, style = Typography.displayLarge, color = firstTextColor)
            SpacerVertical4()
            Text(text = day.dayName, style = Typography.displaySmall, color = secondTextColor)
        }
    }
}