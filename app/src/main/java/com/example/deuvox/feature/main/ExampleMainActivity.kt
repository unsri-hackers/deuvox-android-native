package com.example.deuvox.feature.main

import androidx.lifecycle.ViewModelProvider
import com.example.deuvox.base.activity.BaseActivity
import com.example.deuvox.databinding.ExampleActivityMainBinding
import com.example.deuvox.feature.main.di.DaggerExampleMainComponent

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