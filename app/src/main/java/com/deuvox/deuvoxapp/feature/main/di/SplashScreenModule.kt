package com.deuvox.deuvoxapp.feature.main.di

import androidx.lifecycle.ViewModel
import com.deuvox.deuvoxapp.base.anotation.scope.PerActivity
import com.deuvox.deuvoxapp.base.anotation.viewmodel.ViewModelKey
import com.deuvox.deuvoxapp.feature.main.splashscreen.SplashScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashScreenModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenViewModel::class)
    @PerActivity
    abstract fun splashScreenViewModel(viewModel: SplashScreenViewModel): ViewModel
}