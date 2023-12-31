package com.fzco.mango.di.modules.app.navigation

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {

    @[Provides Singleton]
    fun provideCicerone() = Cicerone.create()


    @[Provides Singleton]
    fun provideRouter(cicerone: Cicerone<Router>) = cicerone.router

    @[Provides Singleton]
    fun provideNavigatorHolder(cicerone: Cicerone<Router>) = cicerone.getNavigatorHolder()
}
