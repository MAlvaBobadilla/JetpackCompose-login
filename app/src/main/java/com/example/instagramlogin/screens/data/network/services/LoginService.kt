package com.example.instagramlogin.screens.data.network.services

import com.example.instagramlogin.screens.data.models.LoginResponse
import com.example.instagramlogin.screens.data.network.LoginClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient:LoginClient ) {

    suspend fun doLoginCallService(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response: Response<LoginResponse> = loginClient.doLogin()
            response.body()?.success ?: false
        }
    }

}