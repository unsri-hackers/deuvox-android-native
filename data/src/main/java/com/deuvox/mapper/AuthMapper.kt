package com.deuvox.mapper

import com.deuvox.auth.remote.response.AuthResponse
import com.deuvox.domain.auth.model.Auth
import com.deuvox.domain.auth.model.Token

fun AuthResponse?.toDomainModel(): Auth {
    return Auth(
        accessToken = Token(
            value = this?.accessToken?.value ?: "",
            type = this?.accessToken?.type ?: "",
            expiredAt = this?.accessToken?.expiredAt ?: 0L
        ),
        refreshToken = Token(
            value = this?.refreshToken?.value ?: "",
            type = this?.refreshToken?.type ?: "",
            expiredAt = this?.refreshToken?.expiredAt ?: 0L
        )
    )
}