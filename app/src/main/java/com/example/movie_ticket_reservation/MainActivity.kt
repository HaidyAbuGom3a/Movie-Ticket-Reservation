package com.example.movie_ticket_reservation

import TransparentStatusBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.movie_ticket_reservation.ui.screens.movies.MoviesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            TransparentStatusBar()
            MoviesScreen()
        }
    }
}
