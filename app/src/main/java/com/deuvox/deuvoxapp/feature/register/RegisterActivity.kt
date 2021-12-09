package com.deuvox.deuvoxapp.feature.register

import android.view.View
import com.deuvox.deuvoxapp.R
import com.deuvox.deuvoxapp.base.delegate.viewModel
import com.deuvox.deuvoxapp.base.activity.BaseActivity
import com.deuvox.deuvoxapp.databinding.RegisterScreenBinding
import com.deuvox.deuvoxapp.feature.main.di.DaggerRegisterComponent
import com.deuvox.domain.auth.register.RegisterParam


class RegisterActivity : BaseActivity<RegisterScreenBinding>() {
    private val viewModel by viewModel<RegisterViewModel>()

    override fun init() {
        viewModel
        binding.btnRegister.setOnClickListener { v ->
            if (v?.id == R.id.btn_register) {
                val param = RegisterParam(
                    binding.registerEmail.text.toString(),
                    binding.registerEmail.text.toString(),
                    binding.registerPassword.text.toString(),
                    binding.registerPassword.text.toString()
                )
                viewModel.register(param)
            }
        }
    }

    override fun getViewBinding(): RegisterScreenBinding = RegisterScreenBinding.inflate(layoutInflater)

    override fun injectComponent() {
        DaggerRegisterComponent.builder()
            .appComponent(applicationComponent)
            .build()
            .inject(this)
    }

}