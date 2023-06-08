package com.example.moviesapp.data.repository

import com.example.moviesapp.data.model.MovieModel
import com.example.moviesapp.data.network.ApiService
import com.example.moviesapp.data.network.RetrofitInstance

class MovieRepository {

    private val api = RetrofitInstance.retrofit.create(ApiService::class.java)

    suspend fun getMovies(): MovieModel? {
        return try {
            api.getTopRatedMovieList()
        } catch (e: Exception) {
            e
            null
        }
    }

}