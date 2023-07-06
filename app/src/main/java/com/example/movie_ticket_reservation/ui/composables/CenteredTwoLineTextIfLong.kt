package com.example.movie_ticket_reservation.ui.composables

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.ui.theme.Typography

@Composable
fun CenteredTwoLineTextIfLong(movieName: String, modifier: Modifier = Modifier) {
    val firstLine: String
    val secondLine: String

    if (movieName.length > 20) {
        val splitIndex = movieName.indexOf(' ', 20)
            .takeIf { it != -1 } ?: movieName.length
        firstLine = movieName.substring(0, splitIndex).trim()
        secondLine = movieName.substring(splitIndex).trim()
    } else {
        firstLine = movieName
        secondLine = ""
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = firstLine,
            style = Typography.titleLarge
        )
        if (secondLine.isNotBlank()) {
            Text(
                text = secondLine,
                style = Typography.titleLarge,
                maxLines = 1,
                modifier = Modifier.padding(horizontal = 32.dp),
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
