package com.example.mvvm_therightway.feature.main

import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_therightway.base.activity.BaseActivity
import com.example.mvvm_therightway.databinding.ExampleActivityMainBinding
import com.example.mvvm_therightway.feature.main.di.DaggerExampleMainComponent

class ExampleMainActivity : BaseActivity<ExampleActivityMainBinding>() {
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ExampleMainViewModel::class.java]
    }

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