package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.movie_ticket_reservation.ui.theme.Typography

@Composable
fun TextMovieTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = Typography.titleLarge,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}