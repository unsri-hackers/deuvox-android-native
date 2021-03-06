package com.deuvox.deuvoxapp.base.viewmodel

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    override fun onCleared() {
        super.onCleared()
        onDispose()
    }

    open fun onDispose() {
        // Override to dispose
    }
}