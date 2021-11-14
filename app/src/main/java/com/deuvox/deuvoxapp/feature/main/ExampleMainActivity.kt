package com.deuvox.deuvoxapp.feature.main

import com.deuvox.deuvoxapp.base.activity.BaseActivity
import com.deuvox.deuvoxapp.base.delegate.viewModel
import com.deuvox.deuvoxapp.databinding.ExampleActivityMainBinding
import com.deuvox.deuvoxapp.feature.main.di.DaggerExampleMainComponent

class ExampleMainActivity : BaseActivity<ExampleActivityMainBinding>() {
    private val viewModel by viewModel<ExampleMainViewModel>()

    override fun getViewBinding(): ExampleActivityMainBinding =
        ExampleActivityMainBinding.inflate(layoutInflater)

    override fun init() {
        viewModel.getData()
    }

    override fun injectComponent() {
        DaggerExampleMainComponent.builder()
            .appComponent(applicationComponent)
            .build()
            .inject(this)
    }
}