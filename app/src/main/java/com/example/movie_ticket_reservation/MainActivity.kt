package com.example.movie_ticket_reservation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setStatusBarColor(Color.White, darkIcons = true)
            val navController = rememberNavController()
            MovieTicketsNavGraph(navController = navController)
        }
    }
}
