package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.ui.theme.Typography

@Composable
fun MovieTextDescription(description: String) {
    Text(
        text = description,
        style = Typography.bodySmall,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 24.dp)
    )
}