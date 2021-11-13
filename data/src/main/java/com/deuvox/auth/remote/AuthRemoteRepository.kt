package com.deuvox.auth.remote

import com.deuvox.auth.remote.request.RegisterRequest
import com.deuvox.auth.remote.response.AuthResponse
import com.deuvox.domain.base.Resource
import com.deuvox.utils.networkCall
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class AuthRemoteRepository @Inject constructor(
    private val authService: AuthService
) {

    fun register(body: RegisterRequest): Observable<Resource<AuthResponse>> {
        return networkCall { authService.register(body) }
    }

}