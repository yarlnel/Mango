package com.fzco.mango.di.modules.app

import android.app.Application
import android.content.Context
import com.fzco.mango.di.modules.app.navigation.NavigationModule
import com.fzco.mango.di.modules.data.network.retrofit.RetrofitModule
import com.fzco.mango.di.modules.data.repository.RepositoryModule
import com.fzco.mango.di.modules.data.service.ServiceModule
import com.fzco.mango.di.modules.presentation.fragment.ContributeInjectorsModule
import com.fzco.mango.di.modules.presentation.utils.UtilsModule
import com.fzco.mango.di.modules.presentation.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides

@Module(includes = [
    NavigationModule::class,
    RetrofitModule::class,
    ServiceModule::class,
    ViewModelModule::class,
    ContributeInjectorsModule::class,
    UtilsModule::class,
    RepositoryModule::class
])
class AppModule {

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext
}
