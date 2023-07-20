package com.fzco.mango.di.components

import android.app.Application
import com.fzco.mango.app.App
import com.fzco.mango.di.modules.app.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
    ]
)
interface AppComponent : AndroidInjector<App> {

    override fun inject(instance: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindApp(application: Application) : Builder

        fun build(): AppComponent
    }
}