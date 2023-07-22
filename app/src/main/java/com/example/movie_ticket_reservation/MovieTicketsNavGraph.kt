package com.example.movie_ticket_reservation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.movie_ticket_reservation.ui.screens.booking.bookingRoute
import com.example.movie_ticket_reservation.ui.screens.movie_details.movieDetailsRoute
import com.example.movie_ticket_reservation.ui.screens.movies.moviesRoute

@Composable
fun MovieTicketsNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HOME) {
        moviesRoute(navController)
        movieDetailsRoute(navController)
        bookingRoute(navController)
    }
}

private const val HOME = "movies"