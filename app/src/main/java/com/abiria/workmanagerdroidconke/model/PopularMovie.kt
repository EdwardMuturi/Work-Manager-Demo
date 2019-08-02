package com.abiria.workmanagerdroidconke.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Edward Muturi on 2019-08-02.
 */


data class PopularMovie(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)