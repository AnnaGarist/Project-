package com.example.moviesapp.data.network

import com.example.moviesapp.data.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET("https://api.themoviedb.org/3/movie/top_rated?api_key=429b6aebbd7edd385f02e48e26f45ecc")
    suspend fun getTopRatedMovieList(): MovieModel
}