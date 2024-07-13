package com.intugine.ibocoding.data.remote

import com.intugine.ibocoding.data.model.Movie
import com.intugine.ibocoding.data.model.MovieList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("wp-content/plugins/whats-on-netflix/json/alldocs.json?_=1700718031139")
    suspend fun getAllMovies(): Response<List<Movie>>

}