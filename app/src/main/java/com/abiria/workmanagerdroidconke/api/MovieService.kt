package com.abiria.workmanagerdroidconke.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * Created by Edward Muturi on 2019-08-02.
 */

private const val BASE_URL= "https://api.themoviedb.org/3/movie/popular"

interface MovieService {
    companion object{
        val getMovieService : MovieService
        get() {
            val retrofit= Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(MovieService::class.java)
        }
    }

}