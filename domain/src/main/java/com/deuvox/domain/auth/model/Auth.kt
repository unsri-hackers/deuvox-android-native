package com.deuvox.domain.auth.model

data class Auth(
    val accessToken: Token,
    val refreshToken: Token
)
