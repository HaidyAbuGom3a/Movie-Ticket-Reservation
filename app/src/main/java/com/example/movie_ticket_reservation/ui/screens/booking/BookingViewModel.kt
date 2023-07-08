package com.example.movie_ticket_reservation.ui.screens.booking

import androidx.lifecycle.ViewModel
import com.example.movie_ticket_reservation.ui.ui_states.AvailabilityType
import com.example.movie_ticket_reservation.ui.ui_states.BookingUiState
import com.example.movie_ticket_reservation.ui.ui_states.DayUiState
import com.example.movie_ticket_reservation.ui.ui_states.SeatsUiState
import com.example.movie_ticket_reservation.ui.ui_states.TimeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class BookingViewModel : ViewModel() {
    private val _state = MutableStateFlow(BookingUiState())
    val state = _state.asStateFlow()

    init {
        getBookingData()
    }

    private fun getBookingData() {
        val days = getDays()
        val times = getTimes()
        val seats = getSeats()
        _state.update {
            it.copy(
                days = days,
                times = times,
                price = 0.0,
                tickets = 0,
                seats = seats,
            )
        }
    }

    fun onClickDayItem(dayUiState: DayUiState) {
        val newSeats = getSeats().shuffled()
        _state.update {
            it.copy(
                days = it.days.map { currentDayUiState ->
                    if (currentDayUiState.dayNum == dayUiState.dayNum) currentDayUiState.copy(
                        isSelected = true
                    )
                    else {
                        currentDayUiState.copy(isSelected = false)
                    }
                },
                seats = newSeats,
                tickets = 0,
                price = 0.0
            )
        }

    }

    fun onClickTimeItem(timeUiState: TimeUiState) {
        val newSeats = getSeats().shuffled()
        _state.update {
            it.copy(
                times = it.times.map { currentTimeUiState ->
                    if (currentTimeUiState.time == timeUiState.time) currentTimeUiState.copy(
                        isSelected = true
                    )
                    else {
                        currentTimeUiState.copy(isSelected = false)
                    }
                },
                seats = newSeats,
                tickets = 0,
                price = 0.0
            )
        }
    }

    fun onClickSeat(isFirstSeat: Boolean, index: Int) {
        _state.update {
            val currentSeatsUiState = it.seats[index]
            var newNumOfTickets = it.tickets
            val newSeatsUiState: SeatsUiState
            if (isFirstSeat && currentSeatsUiState.firstSeatAvailability == AvailabilityType.AVAILABLE) {
                newSeatsUiState = SeatsUiState(
                    AvailabilityType.SELECTED,
                    currentSeatsUiState.secondSeatAvailability
                )
                newNumOfTickets++
            } else if (isFirstSeat && currentSeatsUiState.firstSeatAvailability == AvailabilityType.SELECTED) {
                newSeatsUiState = SeatsUiState(
                    AvailabilityType.AVAILABLE,
                    currentSeatsUiState.secondSeatAvailability
                )
                newNumOfTickets--
            } else if (!isFirstSeat && currentSeatsUiState.secondSeatAvailability == AvailabilityType.AVAILABLE) {
                newSeatsUiState = SeatsUiState(
                    currentSeatsUiState.firstSeatAvailability,
                    AvailabilityType.SELECTED
                )
                newNumOfTickets++
            } else if (!isFirstSeat && currentSeatsUiState.secondSeatAvailability == AvailabilityType.SELECTED) {
                newSeatsUiState = SeatsUiState(
                    currentSeatsUiState.firstSeatAvailability,
                    AvailabilityType.AVAILABLE
                )
                newNumOfTickets--
            } else {
                newSeatsUiState = currentSeatsUiState
            }
            it.copy(
                seats = it.seats.mapIndexed { currentIndex, twoChairsUiState ->
                    if (currentIndex == index) {
                        twoChairsUiState.copy(
                            firstSeatAvailability = newSeatsUiState.firstSeatAvailability,
                            secondSeatAvailability = newSeatsUiState.secondSeatAvailability
                        )
                    } else {
                        twoChairsUiState
                    }
                },
                tickets = newNumOfTickets,
                price = (newNumOfTickets * 25.toDouble())
            )
        }
    }

    private fun getDays() = listOf(
        DayUiState(
            dayNum = "12",
            dayName = "Tue"
        ),
        DayUiState(
            dayNum = "13",
            dayName = "Wed"
        ),
        DayUiState(
            dayNum = "14",
            dayName = "Thu"
        ),
        DayUiState(
            dayNum = "15",
            dayName = "Fri"
        ),
        DayUiState(
            dayNum = "16",
            dayName = "Sat",
            isSelected = true
        ),
        DayUiState(
            dayNum = "17",
            dayName = "Sun"
        ),
        DayUiState(
            dayNum = "18",
            dayName = "Mon"
        ),
        DayUiState(
            dayNum = "19",
            dayName = "Tue"
        ),
        DayUiState(
            dayNum = "20",
            dayName = "Wed"
        ),
        DayUiState(
            dayNum = "21",
            dayName = "Thu"
        )
    )

    private fun getTimes() =
        listOf(
            TimeUiState("10:00", true),
            TimeUiState("12:30"),
            TimeUiState("15:30"),
            TimeUiState("18:30"),
            TimeUiState("21:30"),
            TimeUiState("23:30")
        )

    private fun getSeats() =
        listOf(
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.AVAILABLE,
                secondSeatAvailability = AvailabilityType.AVAILABLE
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.AVAILABLE,
                secondSeatAvailability = AvailabilityType.AVAILABLE
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.TAKEN,
                secondSeatAvailability = AvailabilityType.AVAILABLE
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.AVAILABLE,
                secondSeatAvailability = AvailabilityType.AVAILABLE
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.AVAILABLE,
                secondSeatAvailability = AvailabilityType.AVAILABLE
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.AVAILABLE,
                secondSeatAvailability = AvailabilityType.AVAILABLE
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.TAKEN,
                secondSeatAvailability = AvailabilityType.AVAILABLE
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.AVAILABLE,
                secondSeatAvailability = AvailabilityType.AVAILABLE
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.TAKEN,
                secondSeatAvailability = AvailabilityType.TAKEN
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.AVAILABLE,
                secondSeatAvailability = AvailabilityType.AVAILABLE
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.TAKEN,
                secondSeatAvailability = AvailabilityType.TAKEN
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.AVAILABLE,
                secondSeatAvailability = AvailabilityType.AVAILABLE
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.TAKEN,
                secondSeatAvailability = AvailabilityType.TAKEN
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.TAKEN,
                secondSeatAvailability = AvailabilityType.TAKEN
            ),
            SeatsUiState(
                firstSeatAvailability = AvailabilityType.AVAILABLE,
                secondSeatAvailability = AvailabilityType.AVAILABLE
            ),
        )
}