package com.fzco.mango.di.modules.presentation.fragment

import com.fzco.mango.di.modules.presentation.viewmodel.auth.confirm.ConfirmAuthCodeModule
import com.fzco.mango.di.modules.presentation.viewmodel.auth.send.SendAuthCodeModule
import com.fzco.mango.di.modules.presentation.viewmodel.common.country.SelectCountryCodeModule
import com.fzco.mango.di.modules.presentation.viewmodel.home.HomeModule
import com.fzco.mango.di.modules.presentation.viewmodel.register.RegisterUserModule
import com.fzco.mango.presentation.activities.main.MainActivity
import com.fzco.mango.presentation.screens.auth.confirm.ConfirmAuthCodeFragment
import com.fzco.mango.presentation.screens.auth.send.SendAuthCodeFragment
import com.fzco.mango.presentation.screens.country.SelectCountryCodeFragment
import com.fzco.mango.presentation.screens.home.HomeFragment
import com.fzco.mango.presentation.screens.rigistration.RegisterUserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ContributeInjectorsModule {

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [HomeModule::class])
    fun homeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [SendAuthCodeModule::class])
    fun sendAuthCodeFragment(): SendAuthCodeFragment

    @ContributesAndroidInjector(modules = [ConfirmAuthCodeModule::class])
    fun confirmAuthCodeFragment(): ConfirmAuthCodeFragment

    @ContributesAndroidInjector(modules = [SelectCountryCodeModule::class])
    fun selectCountryCodeFragment(): SelectCountryCodeFragment

    @ContributesAndroidInjector(modules = [RegisterUserModule::class])
    fun registerUserFragment(): RegisterUserFragment
}
