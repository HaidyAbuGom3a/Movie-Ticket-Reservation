package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigation(
    icon1: Int,
    icon2: Int,
    icon3: Int,
    icon4: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        ItemBottomNav(
            isSelected = true,
            icon = icon1,
            modifier = Modifier.padding(start = 16.dp)
        )
        ItemBottomNav(
            isSelected = false,
            icon = icon2
        )
        ItemBottomNav(
            isSelected = false,
            icon = icon3,
            isTicket = true
        )

        ItemBottomNav(
            isSelected = false,
            icon = icon4,
            modifier = Modifier.padding(end = 16.dp)
        )

    }
}