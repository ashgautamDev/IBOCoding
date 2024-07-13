package com.intugine.ibocoding.data.repository

import com.intugine.ibocoding.data.remote.ApiService
import javax.inject.Inject


class MovieRepo @Inject constructor(private val apiService: ApiService) {

    suspend fun getMovies() = apiService.getAllMovies()
}