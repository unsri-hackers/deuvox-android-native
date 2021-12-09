package com.deuvox.auth.remote.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    val email: String,

    val password: String
)