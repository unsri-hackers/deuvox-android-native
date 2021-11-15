package com.deuvox.domain.auth

import com.deuvox.domain.auth.login.LoginParam
import com.deuvox.domain.auth.model.Auth
import com.deuvox.domain.auth.register.RegisterParam
import com.deuvox.domain.base.Resource
import io.reactivex.rxjava3.core.Observable

interface AuthRepository {

    fun register(param: RegisterParam): Observable<Resource<Auth>>

    fun login(param: LoginParam): Observable<Resource<Auth>>
}