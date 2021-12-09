package com.deuvox.deuvoxapp.feature.main.splashscreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.deuvox.deuvoxapp.base.viewmodel.BaseViewModel
import com.deuvox.domain.GetDataUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase
) : BaseViewModel() {

    fun getData() {
        viewModelScope.launch {
            Log.e("TAG", "getData: ${getDataUseCase.getData()}")
        }
    }

}
