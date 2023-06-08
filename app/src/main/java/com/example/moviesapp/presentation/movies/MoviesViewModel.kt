package com.example.moviesapp.presentation.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.model.Result
import com.example.moviesapp.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {

    val topRatedMovieLists = MutableLiveData<List<Result>?>()

    private val movieRepository = MovieRepository()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            topRatedMovieLists.postValue(movieRepository.getMovies()?.results)
        }
    }

}