package com.example.movie_ticket_reservation.ui.screens.booking

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "booking"
fun NavController.navigateToBooking(){
    navigate(ROUTE)
}

fun NavGraphBuilder.bookingRoute(navController: NavController){
    composable(ROUTE){ BookingScreen(navController)}
}