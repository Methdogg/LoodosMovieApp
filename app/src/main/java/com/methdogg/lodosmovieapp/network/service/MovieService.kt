package com.methdogg.lodosmovieapp.network.service

import com.methdogg.lodosmovieapp.data.model.Movie
import com.methdogg.lodosmovieapp.data.remote.MovieListResponse
import com.methdogg.lodosmovieapp.network.util.ApiConstants
import com.methdogg.lodosmovieapp.network.util.ApiConstants.API_URL
import io.reactivex.Observable
import io.reactivex.Single
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET(API_URL)
    fun getMovies(
        @Query("apiKey") apiKey: String = ApiConstants.API_KEY,
        @Query("s") searchQuery: String
    ): Single<MovieListResponse>

}