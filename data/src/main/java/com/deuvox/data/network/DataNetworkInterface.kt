package com.deuvox.data.network

import retrofit2.http.POST

interface DataNetworkInterface {
    @POST("auth/login")
    suspend fun loginRequest() : List<String>
}