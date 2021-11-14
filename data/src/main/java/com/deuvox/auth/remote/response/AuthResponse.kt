package com.deuvox.auth.remote.response

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("access_token")
    val accessToken: TokenResponse?,

    @SerializedName("refresh_token")
    val refreshToken: TokenResponse?
)