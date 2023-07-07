package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movie_ticket_reservation.ui.theme.GoogleSans
import com.example.movie_ticket_reservation.ui.theme.Primary

@Composable
fun ItemBottomNav(
    isSelected: Boolean,
    icon: Int,
    isTicket: Boolean = false,
    modifier: Modifier = Modifier
) {
    val containerColor: Color
    val contentColor: Color
    if (isSelected) {
        containerColor = Primary
        contentColor = Color.White
    } else {
        containerColor = Color.Transparent
        contentColor = Color.Black
    }
    Card(
        shape = CircleShape, colors = CardDefaults.cardColors(
            containerColor = containerColor, contentColor = contentColor
        ),
        modifier = modifier
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painterResource(icon),
                contentDescription = "",
                modifier = Modifier.padding(12.dp)
            )
            if (isTicket) {
                Card(
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = Primary, contentColor = Color.White
                    ),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "5",
                            color = Color.White,
                            fontFamily = GoogleSans,
                            fontWeight = FontWeight.Normal,
                            fontSize = 10.sp,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }
    }
}