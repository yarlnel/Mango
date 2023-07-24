package com.fzco.mango.di.modules.presentation.viewmodel.home

import androidx.lifecycle.ViewModel
import com.fzco.mango.di.common.viewmodel.ViewModelKey
import com.fzco.mango.presentation.screens.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface HomeModule {

    @[Binds IntoMap ViewModelKey(HomeViewModel::class)]
    fun bindVM(vm: HomeViewModel) : ViewModel

    companion object {

        @Provides
        fun provideVM() = HomeViewModel()
    }
}