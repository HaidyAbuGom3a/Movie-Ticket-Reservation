package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun BluredImage(imageBlur: Int) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.50f),
            //.blur(40.dp),
        contentScale = ContentScale.Crop,
        painter = painterResource(imageBlur),
        contentDescription = ""
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.50f)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent, Color.Transparent, Color.White
                    )
                )
            )
    )
}