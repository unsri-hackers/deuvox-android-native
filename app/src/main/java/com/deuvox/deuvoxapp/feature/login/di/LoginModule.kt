package com.deuvox.deuvoxapp.feature.login.di

import androidx.lifecycle.ViewModel
import com.deuvox.deuvoxapp.base.anotation.scope.PerActivity
import com.deuvox.deuvoxapp.base.anotation.viewmodel.ViewModelKey
import com.deuvox.deuvoxapp.feature.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    @PerActivity
    abstract fun provideLoginViewModel(viewModel: LoginViewModel): ViewModel
}