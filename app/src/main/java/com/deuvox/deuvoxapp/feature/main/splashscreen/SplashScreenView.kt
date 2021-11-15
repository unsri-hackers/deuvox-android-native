package com.deuvox.deuvoxapp.feature.main.splashscreen

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.deuvox.deuvoxapp.base.view.BaseRichView
import com.deuvox.deuvoxapp.databinding.SplashScreenBinding

class SplashScreenView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseRichView<SplashScreenBinding>(context, attrs, defStyleAttr) {

    override fun getViewBinding(): SplashScreenBinding =
        SplashScreenBinding.inflate(LayoutInflater.from(context), this, true)

}