package com.fzco.mango.di.modules.presentation.fragment

import com.fzco.mango.presentation.activities.main.MainActivity
import com.fzco.mango.presentation.screens.auth.confirm.ui.ConfirmAuthCodeFragment
import com.fzco.mango.presentation.screens.auth.send.ui.SendAuthCodeFragment
import com.fzco.mango.presentation.screens.country.ui.SelectCountryCodeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ContributeInjectorsModule {

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    fun sendAuthCodeFragment(): SendAuthCodeFragment

    @ContributesAndroidInjector
    fun confirmAuthCodeFragment(): ConfirmAuthCodeFragment

    @ContributesAndroidInjector
    fun selectCountryCodeFragment(): SelectCountryCodeFragment
}