package com.example.movie_ticket_reservation.ui.ui_states

data class BookingUiState(
    val days: List<DayUiState> = emptyList(),
    val times: List<TimeUiState> = emptyList(),
    val price: Double = 0.0,
    val tickets: Int = 0,
    val seats: List<SeatsUiState> = emptyList(),
)

data class DayUiState(
    val dayNum: String = "",
    val dayName: String = "",
    val isSelected: Boolean = false
)

data class TimeUiState(
    val time: String = "",
    val isSelected: Boolean = false
)

data class SeatsUiState(
    val firstSeatAvailability: AvailabilityType = AvailabilityType.AVAILABLE,
    val secondSeatAvailability: AvailabilityType = AvailabilityType.AVAILABLE
)

enum class AvailabilityType {
    AVAILABLE,
    TAKEN,
    SELECTED
}