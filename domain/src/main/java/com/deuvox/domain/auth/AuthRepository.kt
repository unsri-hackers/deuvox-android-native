package com.deuvox.domain.auth

import com.deuvox.domain.auth.model.Auth
import com.deuvox.domain.auth.register.RegisterParam
import io.reactivex.rxjava3.core.Observable

interface AuthRepository {

    fun register(params: RegisterParam): Observable<Auth>

}