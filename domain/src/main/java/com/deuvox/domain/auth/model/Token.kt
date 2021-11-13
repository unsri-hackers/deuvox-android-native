package com.deuvox.domain.auth.model

data class Token(
    val value: String,
    val type: String,
    val expiredAt: String
)
