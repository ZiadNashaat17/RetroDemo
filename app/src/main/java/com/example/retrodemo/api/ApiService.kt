package com.example.retrodemo.api

import com.example.retrodemo.TvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/tv")
    fun getTVs(
        @Query("api_key") key: String,
        @Query("with_genres") id: Int
    ): Call<TvResponse>
}