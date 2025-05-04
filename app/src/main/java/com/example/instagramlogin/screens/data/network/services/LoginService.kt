package com.example.instagramlogin.screens.data.network.services

import com.example.instagramlogin.core.network.retrofitHelper
import com.example.instagramlogin.screens.data.models.LoginResponse
import com.example.instagramlogin.screens.data.network.LoginClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginService {

    private val retrofit = retrofitHelper.getRetrofit()

    suspend fun doLoginCallService(user: String, password: String):Boolean {
        return withContext(Dispatchers.IO) {
            val response: Response<LoginResponse> =
                retrofit.create(LoginClient::class.java).doLogin()

            response.body()?.success ?: false
        }
    }

}