package com.deuvox.domain.auth.login

import com.deuvox.domain.auth.AuthRepository
import com.deuvox.domain.auth.model.Auth
import com.deuvox.domain.base.BaseUseCase
import com.deuvox.domain.base.Resource
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) : BaseUseCase<Auth, LoginParam>() {

    override fun buildUseCase(params: LoginParam): Observable<Resource<Auth>> {
        return authRepository.login(params)
    }

}