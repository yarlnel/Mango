package com.fzco.mango.domain.usecase.user.phone

import com.fzco.mango.domain.core.repository.user.UserProfileRepository
import javax.inject.Inject

class SaveUserPhone @Inject constructor(
    private val userProfileRepository: UserProfileRepository
) {

    suspend operator fun invoke(phone: String) {
        userProfileRepository.phone = phone
    }
}
