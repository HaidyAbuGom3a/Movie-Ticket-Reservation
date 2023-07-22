package com.example.movie_ticket_reservation.ui.screens.movie_details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movie_ticket_reservation.ui.screens.MovieDetailsScreen

private const val ROUTE = "movieDetails"

fun NavController.navigateToMovieDetails(){
    navigate(ROUTE)
}

fun NavGraphBuilder.movieDetailsRoute(navController: NavController){
    composable(ROUTE){ MovieDetailsScreen(navController)}
}