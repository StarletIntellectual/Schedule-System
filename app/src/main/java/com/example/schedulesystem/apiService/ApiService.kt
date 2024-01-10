package com.example.schedulesystem.apiService

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("demo/first")
    fun getTestData(): Call<ResponseBody>
}