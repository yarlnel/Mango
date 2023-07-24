package com.fzco.mango.di.modules.presentation.viewmodel.auth.confirm

import androidx.lifecycle.ViewModel
import com.fzco.mango.di.common.viewmodel.ViewModelKey
import com.fzco.mango.domain.usecase.auth.ConfirmAuthCode
import com.fzco.mango.domain.usecase.user.phone.GetUserPhone
import com.fzco.mango.domain.usecase.user.phone.GetUserPhoneRegionCode
import com.fzco.mango.presentation.screens.auth.confirm.ConfirmAuthCodeViewModel
import com.github.terrakok.cicerone.Router
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
        fun provideVM(
            confirmAuthCode: ConfirmAuthCode,
            getUserPhone: GetUserPhone,
            getUserPhoneRegionCode: GetUserPhoneRegionCode,
            router: Router
        ) = ConfirmAuthCodeViewModel(
            confirmAuthCode,
            getUserPhone,
            getUserPhoneRegionCode,
            router
        )
    }
}
