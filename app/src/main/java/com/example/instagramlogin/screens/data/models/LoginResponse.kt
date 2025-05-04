package com.example.instagramlogin.screens.data.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName ("succes") val success: Boolean
)
