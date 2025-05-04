package com.example.instagramlogin.screens.data.repository

import com.example.instagramlogin.screens.data.network.services.LoginService

class LoginRepository {

    private val api = LoginService()

    suspend fun doLoginCallRepository(user: String, password: String):Boolean {
        return api.doLoginCallService(user = user, password = password)
    }
}