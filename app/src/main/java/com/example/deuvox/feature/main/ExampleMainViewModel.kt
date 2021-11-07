package com.example.deuvox.feature.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.GetDataUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ExampleMainViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase
) : ViewModel() {

    fun getData() {
        viewModelScope.launch {
            Log.e("TAGO", "getData: ${getDataUseCase.getData()}")
        }
    }
}