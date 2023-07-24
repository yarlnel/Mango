package com.fzco.mango.di.modules.data.repository

import com.fzco.mango.data.repository.user.UserProfileRepositoryImpl
import com.fzco.mango.domain.core.repository.user.UserProfileRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable


@Module
interface RepositoryModule {

    @[Binds Reusable]
    fun bindUserProfileRepository(impl: UserProfileRepositoryImpl): UserProfileRepository
}
