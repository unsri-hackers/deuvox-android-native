package com.deuvox.auth.remote

import com.deuvox.auth.remote.request.RegisterRequest
import com.deuvox.auth.remote.response.AuthResponse
import com.deuvox.base.BaseResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/register")
    fun register(@Body body: RegisterRequest): Observable<Response<BaseResponse<AuthResponse>>>

}