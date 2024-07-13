package com.intugine.ibocoding.data.remote

import com.intugine.ibocoding.data.model.Movie
import com.intugine.ibocoding.data.model.MovieList

sealed class NetworkResult {

    data object Empty : NetworkResult()
    data class Success(val data : List<Movie>) : NetworkResult()
    data class Error(val code : String, val message : String) : NetworkResult()
}