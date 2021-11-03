package com.example.mvvm_therightway.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_therightway.base.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}