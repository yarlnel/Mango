package com.fzco.mango.di.modules.presentation.viewmodel.auth.confirm

import androidx.lifecycle.ViewModel
import com.fzco.mango.di.common.viewmodel.ViewModelKey
import com.fzco.mango.presentation.screens.auth.confirm.ConfirmAuthCodeViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface ConfirmAuthCodeModule {

    @[Binds IntoMap ViewModelKey(ConfirmAuthCodeViewModel::class)]
    fun bindVM(vm: ConfirmAuthCodeViewModel): ViewModel

    companion object {

        @Provides
        fun provideVM() = ConfirmAuthCodeViewModel()
    }
}
