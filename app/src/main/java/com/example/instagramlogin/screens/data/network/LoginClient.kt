package com.example.instagramlogin.screens.data.network

import com.example.instagramlogin.screens.data.models.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {

    @GET("/v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014")
    suspend fun doLogin():Response<LoginResponse>

}