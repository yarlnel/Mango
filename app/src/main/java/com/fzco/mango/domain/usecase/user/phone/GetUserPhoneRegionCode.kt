package com.fzco.mango.domain.usecase.user.phone

import com.fzco.mango.domain.core.repository.user.UserProfileRepository
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import javax.inject.Inject

class GetUserPhoneRegionCode @Inject constructor(
    private val userProfileRepository: UserProfileRepository,
) {

    suspend operator fun invoke() = userProfileRepository.phoneRegion
}
