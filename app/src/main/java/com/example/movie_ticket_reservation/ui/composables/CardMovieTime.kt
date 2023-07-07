package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.ui.theme.ColorTransparent

@Composable
fun CardMovieTime(time: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = ColorTransparent,
            contentColor = Color.White
        ),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .wrapContentSize(Alignment.Center),
        shape = CircleShape
    ) {
        MovieTime(time = time)
    }
}