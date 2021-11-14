package com.deuvox.deuvoxapp.feature.register.di

import androidx.lifecycle.ViewModel
import com.deuvox.deuvoxapp.base.anotation.scope.PerActivity
import com.deuvox.deuvoxapp.base.anotation.viewmodel.ViewModelKey
import com.deuvox.deuvoxapp.feature.register.RegisterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RegisterModule {

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    @PerActivity
    abstract fun provideRegisterViewModel(viewModel: RegisterViewModel): ViewModel

}