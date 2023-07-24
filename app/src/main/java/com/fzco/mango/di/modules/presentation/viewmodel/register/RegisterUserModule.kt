package com.fzco.mango.di.modules.presentation.viewmodel.register

import androidx.lifecycle.ViewModel
import com.fzco.mango.di.common.viewmodel.ViewModelKey
import com.fzco.mango.presentation.screens.rigistration.RegisterUserViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface RegisterUserModule {

    @[Binds IntoMap ViewModelKey(RegisterUserViewModel::class)]
    fun bindVM(vm: RegisterUserViewModel): ViewModel

    companion object {

        @Provides
        fun provideVM() = RegisterUserViewModel()
    }
}