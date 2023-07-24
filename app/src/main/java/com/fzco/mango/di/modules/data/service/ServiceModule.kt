package com.fzco.mango.di.modules.data.service

import com.fzco.mango.data.remote.api.MangoApi
import com.fzco.mango.data.service.auth.AuthServiceImpl
import com.fzco.mango.domain.core.service.auth.AuthService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
interface ServiceModule {

    @[Binds Reusable]
    fun bindAuthService(service: AuthServiceImpl) :AuthService
}
