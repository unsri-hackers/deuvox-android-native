package com.deuvox.deuvoxapp.feature.login

import com.deuvox.deuvoxapp.base.viewmodel.BaseViewModel
import com.deuvox.domain.auth.login.LoginParam
import com.deuvox.domain.auth.login.LoginUseCase
import timber.log.Timber
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    init {
        val param = LoginParam(
            "example@mail.com",
            "k3j4k23ioewjskfj123"
        )
        loginUseCase.execute(param, {
            Timber.e("$it")
        })
    }

    override fun onDispose() {
        super.onDispose()
        loginUseCase.dispose()
    }
}