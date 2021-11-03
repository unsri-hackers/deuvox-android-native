package com.example.mvvm_therightway.base.viewmodel

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