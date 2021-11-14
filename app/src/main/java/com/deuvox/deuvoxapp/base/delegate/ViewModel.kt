package com.deuvox.deuvoxapp.base.delegate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deuvox.deuvoxapp.base.activity.BaseActivity

inline fun <reified T : ViewModel> BaseActivity<*>.viewModel(): Lazy<T> = lazy {
    ViewModelProvider(this, viewModelFactory)[T::class.java]
}