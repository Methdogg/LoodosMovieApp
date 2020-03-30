package com.methdogg.lodosmovieapp.data.remote

import com.google.gson.annotations.SerializedName
import com.methdogg.lodosmovieapp.data.model.Movie
import java.io.Serializable

data class MovieListResponse(
    @SerializedName("Search") val searchList: List<Movie>,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("Response") val isResponseSuccess: String
) : Serializable
