package com.example.movie_ticket_reservation.ui.screens.movies

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "movies"

fun NavGraphBuilder.moviesRoute(navController: NavController) {
    composable(ROUTE) { MoviesScreen(navController = navController) }
}