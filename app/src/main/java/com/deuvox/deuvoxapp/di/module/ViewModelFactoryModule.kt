package com.deuvox.deuvoxapp.di.module

import androidx.lifecycle.ViewModelProvider
import com.deuvox.deuvoxapp.base.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelFactoryModule {
    @Binds
    @Singleton
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}