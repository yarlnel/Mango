package com.fzco.mango.data.repository.user

import android.content.Context
import com.fzco.mango.data.utils.cahe.CacheRepository
import com.fzco.mango.domain.core.repository.user.UserProfileRepository
import javax.inject.Inject

class UserProfileRepositoryImpl @Inject constructor(
    context: Context
) : CacheRepository(context),
    UserProfileRepository {

    override var phone by prefString()
    override var phoneRegion by prefString()
}
