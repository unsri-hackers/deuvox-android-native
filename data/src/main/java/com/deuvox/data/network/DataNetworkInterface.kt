package com.deuvox.data.network

import retrofit2.http.POST
import retrofit2.http.Path

interface DataNetworkInterface {
    @POST("auth/login")
    suspend fun loginRequest(
        @Path("username") username: String,
        @Path("password") password: String)
    : List<String>
}