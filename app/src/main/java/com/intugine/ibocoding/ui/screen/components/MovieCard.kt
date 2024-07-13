package com.intugine.ibocoding.ui.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.intugine.ibocoding.R

@Composable
fun MovieCard(modifier: Modifier = Modifier, url: String, text: String) {

    Column(
        modifier = Modifier
            .height(200.dp)
            .width(200.dp),
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Movie Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
        )

        Text(text = "sdlkf")

    }
}

@Preview
@Composable
private fun movieCard() {
    MovieCard(
        text = " Movie Name",
        url = "https://www.whats-on-netflix.com/wp-content/uploads/covers/crimescenethetexaskillingfields.jpeg"
    )
}