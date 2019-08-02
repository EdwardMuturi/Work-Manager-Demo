package com.abiria.workmanagerdroidconke.api

import androidx.lifecycle.LiveData
import com.abiria.workmanagerdroidconke.model.PopularMovie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Edward Muturi on 2019-08-02.
 */

private const val BASE_URL = "https://api.themoviedb.org/3/"

interface MovieService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: String
    ): Call<PopularMovie>

    companion object {
        val getMovieService: MovieService
            get() {
                val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()

                return retrofit.create(MovieService::class.java)
            }
    }

}