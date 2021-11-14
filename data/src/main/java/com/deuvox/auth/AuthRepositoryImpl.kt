package com.deuvox.auth

import com.deuvox.auth.remote.AuthRemoteRepository
import com.deuvox.domain.auth.AuthRepository
import com.deuvox.domain.auth.model.Auth
import com.deuvox.domain.auth.register.RegisterParam
import com.deuvox.domain.base.Resource
import com.deuvox.mapper.toDomainModel
import com.deuvox.mapper.toRequestBody
import com.deuvox.utils.mapResource
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remoteRepository: AuthRemoteRepository
) : AuthRepository {

    override fun register(param: RegisterParam): Observable<Resource<Auth>> {
        return remoteRepository.register(param.toRequestBody()).mapResource { it.toDomainModel() }
    }

}