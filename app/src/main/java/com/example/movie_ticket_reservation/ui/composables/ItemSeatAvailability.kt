package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.ui.theme.Gray300
import com.example.movie_ticket_reservation.ui.theme.Typography

@Composable
fun ItemSeatAvailability(text: String, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Spacer(
            modifier = Modifier
                .size(8.dp)
                .clip(shape = CircleShape)
                .background(color)
        )
        Text(
            text = text,
            color = Gray300,
            style = Typography.displaySmall,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}