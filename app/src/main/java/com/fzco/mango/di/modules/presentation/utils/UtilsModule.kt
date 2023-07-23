package com.fzco.mango.di.modules.presentation.utils

import android.app.Application
import dagger.Module
import dagger.Provides
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import javax.inject.Singleton

@Module
class UtilsModule {

    @[Provides Singleton]
    fun providePhoneNumberUtil(application: Application): PhoneNumberUtil =
        PhoneNumberUtil.createInstance(application.applicationContext)
}