package com.fzco.mango.di.modules.presentation.viewmodel.register

import androidx.lifecycle.ViewModel
import com.fzco.mango.di.common.viewmodel.ViewModelKey
import com.fzco.mango.domain.usecase.user.phone.GetUserPhone
import com.fzco.mango.domain.usecase.user.phone.GetUserPhoneCountryEmoji
import com.fzco.mango.domain.usecase.user.register.RegisterUser
import com.fzco.mango.presentation.screens.rigistration.RegisterUserViewModel
import com.fzco.mango.presentation.screens.rigistration.RegistrationFieldsValidator
import com.github.terrakok.cicerone.Router
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
        fun provideVM(
            getUserPhone: GetUserPhone,
            getUserPhoneCountryEmoji: GetUserPhoneCountryEmoji,
            fieldsValidator: RegistrationFieldsValidator,
            registerUser: RegisterUser,
            router: Router
        ) = RegisterUserViewModel(
            getUserPhone,
            getUserPhoneCountryEmoji,
            fieldsValidator,
            registerUser,
            router
        )
    }
}