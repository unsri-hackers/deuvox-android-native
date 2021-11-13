package com.deuvox.auth.remote.response

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    val value: String?,

    val type: String?,

    @SerializedName("expired_at")
    val expiredAt: Long?
)