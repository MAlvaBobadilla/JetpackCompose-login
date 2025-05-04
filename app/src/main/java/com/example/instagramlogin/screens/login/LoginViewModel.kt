package com.example.instagramlogin.screens.login

import androidx.annotation.OptIn
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import com.example.instagramlogin.screens.domain.useCases.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val loginUseCase = LoginUseCase()

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
    private val _isEnabled = MutableLiveData<Boolean>()
    val isEnabled: LiveData<Boolean> = _isEnabled
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun onValueChange(correo: String, contrasena: String) {
        _email.value = correo
        _password.value = contrasena
        _isEnabled.value = enableLogin(email = correo, password = contrasena)
    }

    fun enableLogin(email: String, password: String) = email.isNotEmpty() && password.length > 6

    @OptIn(UnstableApi::class)
    fun onButtonSelected() {
        viewModelScope.launch {
            _isLoading.value = true
            val response =
                loginUseCase.doLoginUseCase(user = email.value!!, password = password.value!!)
            if (response) {
                Log.i("envio", "Se presiono")
                _isLoading.value = false
            } else {
                Log.i("envio", "Respuesta $response")
            }
        }

    }

}