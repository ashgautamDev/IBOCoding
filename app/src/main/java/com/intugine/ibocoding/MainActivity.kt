package com.intugine.ibocoding

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.intugine.ibocoding.data.remote.NetworkResult
import com.intugine.ibocoding.ui.screen.MovieViewModel
import com.intugine.ibocoding.ui.theme.IBOCodingTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IBOCodingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        viewModel.getMovies()
        lifecycleScope.launch {
           viewModel.moviesState.collect { it ->

               when(it){
                   NetworkResult.Empty -> {
                       Log.d(TAG, "onCreate: Empty ")
                   }
                   is NetworkResult.Error -> {
                       Log.d(TAG, "onCreate: Error : ${it.message} ")
                   }
                   is NetworkResult.Success -> {
                       Log.d(TAG, "onCreate: Success : ${it.data}")
                   }
               }


           }

        }



    }

    companion object{
        const val TAG = "MainActivity"
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IBOCodingTheme {
        Greeting("Android")
    }
}