package com.intugine.ibocoding.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intugine.ibocoding.data.remote.NetworkResult
import com.intugine.ibocoding.data.repository.MovieRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repo: MovieRepo) : ViewModel() {

    private val _moviesState = MutableStateFlow<NetworkResult>(NetworkResult.Empty)
    val moviesState = _moviesState.asStateFlow()


    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getMovies()

            if (response.isSuccessful) {
                if (response.body() != null) {
                    _moviesState.value = NetworkResult.Success(data = response.body()!!)
                } else {
                    _moviesState.value = NetworkResult.Empty
                }

            } else {
                _moviesState.value =
                    NetworkResult.Error(response.code().toString(), response.message().toString())
            }


        }
    }
}