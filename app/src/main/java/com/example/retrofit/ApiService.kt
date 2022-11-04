package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("15077586/v1/centers")
    fun getInfo(
        @Query("page") page:Int,
        @Query("perPage") perPage:Int,
        @Query("serviceKey") serviceKey:String
    ):Call<Vaccine>
}