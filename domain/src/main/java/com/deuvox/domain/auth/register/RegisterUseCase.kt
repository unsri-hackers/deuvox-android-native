package com.deuvox.domain.auth.register

import com.deuvox.domain.auth.AuthRepository
import com.deuvox.domain.auth.model.Auth
import com.deuvox.domain.base.BaseUseCase
import com.deuvox.domain.base.Resource
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository
) : BaseUseCase<Auth, RegisterParam>() {

    override fun buildUseCase(params: RegisterParam): Observable<Resource<Auth>> {
        return authRepository.register(params)
    }

}