package com.example.movie_ticket_reservation.ui.screens.movie_details

import androidx.lifecycle.ViewModel
import com.example.movie_ticket_reservation.ui.ui_states.ActorsUiState
import com.example.movie_ticket_reservation.ui.ui_states.MovieDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class MovieDetailsViewModel : ViewModel() {
    private val _state = MutableStateFlow(MovieDetailsUiState())
    val state = _state.asStateFlow()

    init {
        getMovieName()
        getMovieImage()
        getMovieDescription()
        getMovieGenres()
        getRatings()
        getActors()
        getMovieTime()
    }

    private fun getMovieImage() {
        _state.update { it.copy(imageUrl = "https://i.pinimg.com/originals/8b/7b/34/8b7b3481524411b38731d40d0644e5ca.jpg") }
    }

    private fun getMovieName() {
        _state.update { it.copy(name = "Fantastic Beasts: The Secrets of Dumbledore") }
    }

    private fun getMovieGenres() {
        _state.update { it.copy(movieGenre = listOf("Fantasy", "Adventure")) }
    }

    private fun getMovieDescription() {
        _state.update { it.copy(description = "Professor Albus Dumbledore knows the powerful Dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts Magizoologist Newt Scamander to lead an intrepid team of wizards, witches and one brave Muggle baker on a dangerous mission, where they encounter old and new beasts and clash with Grindelwald's growing legion of followers. But with the stakes so high, how long can Dumbledore remain on the sidelines?") }
    }

    private fun getRatings() {
        getIMDbRating()
        getRottenTomatoesRating()
        getIGNRating()
    }

    private fun getIMDbRating() {
        _state.update { it.copy(IMDbRate = "6.8") }
    }

    private fun getRottenTomatoesRating() {
        _state.update { it.copy(rottenTomatoesRate = "63%") }
    }

    private fun getIGNRating() {
        _state.update { it.copy(IGNRate = "4") }
    }

    private fun getActors(){
        val actors = listOf(
            ActorsUiState(actorImageUrl = "https://pyxis.nymag.com/v1/imgs/5e3/c1a/b5c147858f5022732164fcbd645b1e38a3-jude-law.rsquare.w330.jpg"),
            ActorsUiState(actorImageUrl = "https://m.media-amazon.com/images/M/MV5BMTU0MjEyNzQyM15BMl5BanBnXkFtZTcwMTc4ODUxOQ@@._V1_.jpg"),
            ActorsUiState(actorImageUrl = "https://nationaltoday.com/wp-content/uploads/2022/10/456840842-min-1200x834.jpg.webp"),
            ActorsUiState(actorImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFJwvrWQtYoX_KqQUXZRs6FNRSaNCqb2-BFjtVxXkfFa1jUpF2z7YJqrj7orOewetYRJA&usqp=CAU"),
            ActorsUiState(actorImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYt6I-Pi-But4S9lFulWLRtd42wQhPp0038tQz4g8AbLdijE3qlfi-2---nG8eo1g_ftg&usqp=CAU"),
            ActorsUiState(actorImageUrl = "https://drive.google.com/file/d/1-UENqiY8z__Eq9aDY-VoudNCPeCgS8hM/view?usp=sharing"),
            ActorsUiState(actorImageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Ezra_Miller_by_Gage_Skidmore_2.jpg/800px-Ezra_Miller_by_Gage_Skidmore_2.jpg" ),
            ActorsUiState(actorImageUrl = "https://static.wikia.nocookie.net/the-royals/images/e/eb/PoppyCorby-Tuech.jpg/revision/latest?cb=20150324221521")
        )
        _state.update { it.copy(
            actors = actors
        ) }
    }

    private fun getMovieTime(){
        _state.update { it.copy(movieTime = "2h 23m") }
    }
}
