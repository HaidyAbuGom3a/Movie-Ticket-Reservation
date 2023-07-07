package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.theme.Gray100
import com.example.movie_ticket_reservation.ui.theme.Typography

@Composable
fun MovieTime(time: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_clock),
            contentDescription = "",
            modifier = Modifier.padding(vertical = 8.dp).padding(start = 8.dp, end = 4.dp),
            tint = Gray100
        )
        Text(
            text = time,
            style = Typography.displaySmall,
            modifier = Modifier.padding(end = 8.dp)
        )

    }
}