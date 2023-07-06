package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.ui.theme.Gray100

@Composable
fun ItemMovieGenre(genre: String) {
    Card(
        shape = RoundedCornerShape(32.dp),
        modifier = Modifier.padding(top = 24.dp),
        border = BorderStroke(width = 0.5.dp, color = Gray100)
    ) {
        Text(
            text = genre,
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .background(Color.White)
        )
    }
}