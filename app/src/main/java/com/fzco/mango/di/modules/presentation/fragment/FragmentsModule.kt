package com.fzco.mango.di.modules.presentation.fragment

import com.fzco.mango.presentation.activities.main.MainActivity
import com.fzco.mango.presentation.screens.auth.confirm.ui.ConfirmAuthCodeFragment
import com.fzco.mango.presentation.screens.auth.send.ui.SendAuthCodeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentsModule {

    @ContributesAndroidInjector
    fun sendAuthCodeFragment(): SendAuthCodeFragment

    @ContributesAndroidInjector
    fun confirmAuthCodeFragment(): ConfirmAuthCodeFragment

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity
}
