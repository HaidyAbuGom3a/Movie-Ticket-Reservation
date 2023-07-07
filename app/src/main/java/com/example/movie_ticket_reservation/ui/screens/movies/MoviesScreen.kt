package com.example.movie_ticket_reservation.ui.screens.movies

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.composables.BluredImage
import com.example.movie_ticket_reservation.ui.composables.BottomNavigation
import com.example.movie_ticket_reservation.ui.composables.CardMovieStatus
import com.example.movie_ticket_reservation.ui.composables.MovieGenreLazyRow
import com.example.movie_ticket_reservation.ui.composables.MovieTime
import com.example.movie_ticket_reservation.ui.composables.MoviesPager
import com.example.movie_ticket_reservation.ui.composables.SpacerVertical24
import com.example.movie_ticket_reservation.ui.composables.SpacerVertical32
import com.example.movie_ticket_reservation.ui.composables.TextMovieTitle
import com.example.movie_ticket_reservation.ui.ui_states.MoviesUiState

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    MoviesContent(state)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesContent(
    state: MoviesUiState
) {
    Box {
        val pagerState = rememberPagerState(initialPage = 1) { state.movies.size }
        BluredImage(imageBlur = state.movies[pagerState.currentPage].imageBlur)
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardMovieStatus(state = state.movies[pagerState.currentPage])
            SpacerVertical32()
            MoviesPager(pagerState = pagerState, state = state)
            SpacerVertical24()
            MovieTime(time = state.movies[pagerState.currentPage].movieTime)
            SpacerVertical24()
            TextMovieTitle(
                text = state.movies[pagerState.currentPage].name,
                modifier = Modifier.padding(horizontal = 40.dp)
            )
            MovieGenreLazyRow(genres = state.movies[pagerState.currentPage].movieGenre)
            BottomNavigation(
                icon1 = R.drawable.icon_video_play,
                icon2 = R.drawable.icon_search_normal,
                icon3 = R.drawable.icon_ticket,
                icon4 = R.drawable.icon_profile,
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            SpacerVertical24()

        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun previewMoviesScreen() {
    val viewModel: MoviesViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    MoviesContent(state = state)
}
