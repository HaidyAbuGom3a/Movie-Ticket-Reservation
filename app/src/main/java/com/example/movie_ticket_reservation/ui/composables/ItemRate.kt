package com.example.movie_ticket_reservation.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movie_ticket_reservation.R
import com.example.movie_ticket_reservation.ui.theme.Gray200
import com.example.movie_ticket_reservation.ui.theme.Typography

@Composable
fun ItemRate(rate: String, websiteName: String, isPercent: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            Text(text = rate, style = Typography.displayMedium)
            if (!isPercent) Text(
                text = stringResource(R.string.rating_from_ten),
                style = Typography.displayMedium,
                color = Gray200
            )
        }
        Text(text = websiteName, style = Typography.displaySmall, color = Gray200)
    }
}

@Preview
@Composable
fun previewItemRate() {
    ItemRate("6.8", "IMDb", false)
}