package com.deuvox.deuvoxapp.feature.register

import com.deuvox.deuvoxapp.base.viewmodel.BaseViewModel
import com.deuvox.domain.auth.register.RegisterParam
import com.deuvox.domain.auth.register.RegisterUseCase
import timber.log.Timber
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : BaseViewModel() {

    init {
        val param = RegisterParam(
            "email@example.com",
            "John Doe",
            "jh0nD03",
            "jh0nD03"
        )
        registerUseCase.execute(param, {
            Timber.e("$it")
        })
    }

    fun register(registerParam: RegisterParam) {
        registerUseCase.execute(registerParam, {
            Timber.e("$it")
        })
    }
    override fun onDispose() {
        super.onDispose()
        registerUseCase.dispose()
    }

}