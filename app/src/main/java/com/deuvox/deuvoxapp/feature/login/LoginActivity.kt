package com.deuvox.deuvoxapp.feature.login

import com.deuvox.deuvoxapp.base.activity.BaseActivity
import com.deuvox.deuvoxapp.base.delegate.viewModel
import com.deuvox.deuvoxapp.databinding.LoginScreenBinding
import com.deuvox.deuvoxapp.feature.login.di.DaggerLoginComponent

class LoginActivity : BaseActivity<LoginScreenBinding>() {

    private val viewModel by viewModel<LoginViewModel>()

    override fun getViewBinding(): LoginScreenBinding = LoginScreenBinding.inflate(layoutInflater)

    override fun init() {
        viewModel
    }

    override fun injectComponent() {
        DaggerLoginComponent.builder()
            .appComponent(applicationComponent)
            .build()
            .inject(this)
    }
}