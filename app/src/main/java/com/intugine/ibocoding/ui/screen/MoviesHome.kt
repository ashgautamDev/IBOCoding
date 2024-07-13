package com.intugine.ibocoding.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.intugine.ibocoding.data.model.Movie
import com.intugine.ibocoding.ui.screen.components.MovieCard

@Composable
fun MoviesHome(modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxSize()){

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
//            items() { it ->
//                MovieCard(url = it , text = )
//            }
        }
    }
}