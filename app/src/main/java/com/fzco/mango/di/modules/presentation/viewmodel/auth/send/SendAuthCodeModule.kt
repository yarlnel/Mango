package com.fzco.mango.di.modules.presentation.viewmodel.auth.send

import androidx.lifecycle.ViewModel
import com.fzco.mango.di.common.viewmodel.ViewModelKey
import com.fzco.mango.domain.usecase.auth.SendAuthCode
import com.fzco.mango.domain.usecase.user.phone.SaveUserPhoneData
import com.fzco.mango.presentation.screens.auth.send.SendAuthCodeViewModel
import com.github.terrakok.cicerone.Router
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface SendAuthCodeModule {

    @[Binds IntoMap ViewModelKey(SendAuthCodeViewModel::class)]
    fun bindVM(vm: SendAuthCodeViewModel): ViewModel

    companion object {

        @Provides
        fun provideVM(
            router: Router,
            sendAuthCode: SendAuthCode,
            saveUserPhoneData: SaveUserPhoneData
        ) = SendAuthCodeViewModel(router, sendAuthCode, saveUserPhoneData)
    }
}