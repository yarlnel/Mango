package com.fzco.mango.di.modules.app

import com.fzco.mango.di.modules.app.navigation.NavigationModule
import com.fzco.mango.di.modules.data.network.retrofit.RetrofitModule
import com.fzco.mango.di.modules.data.service.ServiceModule
import com.fzco.mango.di.modules.presentation.fragment.FragmentsModule
import com.fzco.mango.di.modules.presentation.viewmodel.base.ViewModelModule
import dagger.Module

@Module(includes = [
    NavigationModule::class,
    RetrofitModule::class,
    ServiceModule::class,
    ViewModelModule::class,
    FragmentsModule::class
])
interface AppModule
