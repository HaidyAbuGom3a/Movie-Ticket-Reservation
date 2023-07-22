package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.rememberAsyncImagePainter
import com.example.movie_ticket_reservation.ui.ui_states.MoviesUiState
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesPager(
    pagerState: PagerState,
    state: MoviesUiState,
    onClickMovie: () -> Unit,
    imageHeight: Dp = 350.dp
) {
    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 65.dp),
        modifier = Modifier.height(imageHeight)
    ) { page ->
        Card(
            modifier = Modifier
                .aspectRatio(4f / 5.5f)
                .graphicsLayer {
                    val pageOffset =
                        ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                    alpha = lerp(
                        start = 0.7f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )

                    scaleY = lerp(
                        start = 0.8f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
                .clickable { onClickMovie() }, elevation = CardDefaults.cardElevation(0.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(model = state.movies[page].imageUrl),
                contentDescription = ""
            )
        }
    }
}