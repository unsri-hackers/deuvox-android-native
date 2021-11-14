package com.deuvox.auth.remote.request

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    val email: String,

    @SerializedName("fullname")
    val fullName: String,

    val password: String,

    @SerializedName("confirm_password")
    val confirmPassword: String
)