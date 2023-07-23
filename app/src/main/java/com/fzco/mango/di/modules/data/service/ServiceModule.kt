package com.fzco.mango.di.modules.data.service

import com.fzco.mango.data.remote.api.MangoApi
import com.fzco.mango.data.service.auth.AuthService
import com.fzco.mango.domain.core.service.auth.IAuthService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
interface ServiceModule {

    @Binds
    fun bindAuthService(service: AuthService) : IAuthService

    companion object {

        @[Provides Reusable]
        fun provideAuthService(api: MangoApi) = AuthService(api)
    }
}
