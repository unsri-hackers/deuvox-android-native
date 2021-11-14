package com.deuvox.deuvoxapp.feature.register

import com.deuvox.deuvoxapp.base.viewmodel.BaseViewModel
import com.deuvox.domain.auth.register.RegisterParam
import com.deuvox.domain.auth.register.RegisterUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
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
        registerUseCase.buildUseCase(param)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Timber.e("$it")
            }
    }

    override fun onDispose() {
        super.onDispose()
        registerUseCase.dispose()
    }

}