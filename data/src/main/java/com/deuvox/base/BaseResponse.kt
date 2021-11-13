package com.deuvox.base

data class BaseResponse<T>(
    val message: String,

    val data: T?
)
