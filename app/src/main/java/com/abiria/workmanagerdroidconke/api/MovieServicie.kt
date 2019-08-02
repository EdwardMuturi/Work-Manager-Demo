package com.abiria.workmanagerdroidconke.api

import retrofit2.Retrofit

/**
 * Created by Edward Muturi on 2019-08-02.
 */

private const val BASE_URL= "https://api.themoviedb.org/3/movie/popular"

interface MovieServicie {
    companion object{
        val getMovieServicie : MovieServicie
        get() {
            val retrofit= Retrofit.Builder()
                .addConverterFactory(Gson)
        }
    }

}