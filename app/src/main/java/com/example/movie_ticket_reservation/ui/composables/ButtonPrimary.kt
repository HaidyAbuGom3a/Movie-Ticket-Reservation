package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.ui.theme.Primary
import com.example.movie_ticket_reservation.ui.theme.Typography

@Composable
fun ButtonPrimary(
    text: String,
    onClick: () -> Unit,
    hasIcon: Boolean = false,
    icon: Painter? = null,
    contentDescription: String = "",
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = Primary),
        onClick = onClick,
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        if (hasIcon && icon != null) {
            Icon(
                painter = icon,
                contentDescription = contentDescription,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .padding(end = 8.dp)
            )
        }
        Text(text = text, style = Typography.labelSmall)
    }
}