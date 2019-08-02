package com.abiria.workmanagerdroidconke.view.activity

import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.abiria.workmanagerdroidconke.R
import com.abiria.workmanagerdroidconke.api.MovieService
import com.abiria.workmanagerdroidconke.model.PopularMovie
import com.abiria.workmanagerdroidconke.util.Constants.Companion.API_KEY
import com.abiria.workmanagerdroidconke.util.Constants.Companion.TMDB_LANGUAGE
import com.abiria.workmanagerdroidconke.util.Constants.Companion.TMDB_PAGE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var popularMovieJson : String
    private val TAG= MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchPopularMovie()
    }

    fun fetchPopularMovie(){
        MovieService.getMovieService.getPopularMovies(API_KEY, TMDB_LANGUAGE, TMDB_PAGE).enqueue(object:
            Callback<PopularMovie>{
            override fun onFailure(call: Call<PopularMovie>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

            override fun onResponse(call: Call<PopularMovie>, response: Response<PopularMovie>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        popularMovieJson= response.body().toString()
                        Log.d(TAG, popularMovieJson)
                    }

                }
            }

        })
    }


}
