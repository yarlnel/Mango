package com.fzco.mango.domain.usecase.user.phone

import com.fzco.mango.domain.core.repository.user.UserProfileRepository
import javax.inject.Inject

class GetUserPhone @Inject constructor(
    private val profileRepository: UserProfileRepository
) {

    suspend operator fun invoke() = profileRepository.phone
}
