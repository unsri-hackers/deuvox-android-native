package com.deuvox.domain.auth.register

data class RegisterParam(
    val email: String,
    val fullName: String,
    val password: String,
    val confirmPassword: String
)