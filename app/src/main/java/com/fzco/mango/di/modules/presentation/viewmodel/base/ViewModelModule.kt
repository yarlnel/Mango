package com.fzco.mango.di.modules.presentation.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fzco.mango.di.common.viewmodel.DaggerViewModelFactory
import com.fzco.mango.di.common.viewmodel.ViewModelKey
import com.fzco.mango.presentation.screens.auth.confirm.vm.ConfirmAuthCodeViewModel
import com.fzco.mango.presentation.screens.auth.send.vm.SendAuthCodeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindDaggerViewModelFactory(
        factory: DaggerViewModelFactory
    ) : ViewModelProvider.Factory

    @[Binds IntoMap ViewModelKey(SendAuthCodeViewModel::class)]
    fun bindSendAuthCodeViewModel(vm: SendAuthCodeViewModel): ViewModel


    @[Binds IntoMap ViewModelKey(ConfirmAuthCodeViewModel::class)]
    fun bindConfirmAuthCodeViewModel(vm: ConfirmAuthCodeViewModel): ViewModel
}
