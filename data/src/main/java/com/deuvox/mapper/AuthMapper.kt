package com.deuvox.mapper

import com.deuvox.auth.remote.request.LoginRequest
import com.deuvox.auth.remote.request.RegisterRequest
import com.deuvox.auth.remote.response.AuthResponse
import com.deuvox.domain.auth.login.LoginParam
import com.deuvox.domain.auth.model.Auth
import com.deuvox.domain.auth.model.Token
import com.deuvox.domain.auth.register.RegisterParam

fun RegisterParam.toRequestBody(): RegisterRequest {
    return RegisterRequest(
        email = this.email,
        fullName = this.fullName,
        password = this.password,
        confirmPassword = this.confirmPassword
    )
}

fun LoginParam.toRequestBody(): LoginRequest {
    return LoginRequest(
        email = this.email,
        password = this.password
    )
}

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