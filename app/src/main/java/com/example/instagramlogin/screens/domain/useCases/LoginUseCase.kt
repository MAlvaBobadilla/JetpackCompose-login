package com.example.instagramlogin.screens.domain.useCases

import com.example.instagramlogin.screens.data.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) {

    suspend fun doLoginUseCase(user: String, password: String): Boolean {
        return repository.doLoginCallRepository(user = user, password = password)
    }

}