package com.fzco.mango.di.modules.presentation.viewmodel.common.country

import androidx.lifecycle.ViewModel
import com.fzco.mango.di.common.viewmodel.ViewModelKey
import com.fzco.mango.presentation.screens.country.SelectCountryCodeViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil

@Module
interface SelectCountryCodeModule {

    @[Binds IntoMap ViewModelKey(SelectCountryCodeViewModel::class)]
    fun bindVM(vm: SelectCountryCodeViewModel): ViewModel

    companion object {
        @Provides
        fun provideVM(phoneUtil: PhoneNumberUtil) = SelectCountryCodeViewModel(phoneUtil)
    }
}
