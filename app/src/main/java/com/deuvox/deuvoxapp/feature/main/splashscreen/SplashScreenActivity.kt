package com.deuvox.deuvoxapp.feature.main.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.deuvox.deuvoxapp.base.activity.BaseActivity
import com.deuvox.deuvoxapp.databinding.SplashScreenBinding
import com.deuvox.deuvoxapp.feature.main.ExampleMainActivity
import com.deuvox.deuvoxapp.feature.main.di.DaggerSplashScreenComponent
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : BaseActivity<SplashScreenBinding>() {
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[SplashScreenViewModel::class.java]
    }

    override fun getViewBinding(): SplashScreenBinding =
        SplashScreenBinding.inflate(layoutInflater)

    override fun init() {
        viewModel.getData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainScope().launch {
            delay(2000)
            startActivity(Intent(this@SplashScreenActivity, ExampleMainActivity::class.java))
            finish()
        }
    }

    override fun injectComponent() {
        DaggerSplashScreenComponent.builder()
            .appComponent(applicationComponent)
            .build()
            .inject(this)
    }
}