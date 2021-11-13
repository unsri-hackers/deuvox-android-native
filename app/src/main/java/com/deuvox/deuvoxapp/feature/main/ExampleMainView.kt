package com.deuvox.deuvoxapp.feature.main

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.deuvox.deuvoxapp.base.extension.setOnDebounceSearchListener
import com.deuvox.deuvoxapp.base.extension.setThrottleClickListener
import com.deuvox.deuvoxapp.base.view.BaseRichView
import com.deuvox.deuvoxapp.databinding.ViewExampleBinding

class ExampleMainView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseRichView<ViewExampleBinding>(context, attrs, defStyleAttr) {

    override fun getViewBinding(): ViewExampleBinding =
        ViewExampleBinding.inflate(LayoutInflater.from(context), this, true)

    override fun setup() {
        binding.run {
            commonEditText.setOnDebounceSearchListener {
                textView.text = it
            }

            button.setThrottleClickListener {
                textView.text = Math.random().toString()
            }
        }
    }
}