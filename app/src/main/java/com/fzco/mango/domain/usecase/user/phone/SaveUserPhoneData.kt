package com.fzco.mango.domain.usecase.user.phone

import com.fzco.mango.domain.core.repository.user.UserProfileRepository
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import io.michaelrocks.libphonenumber.android.Phonenumber.PhoneNumber
import javax.inject.Inject

class SaveUserPhoneData @Inject constructor(
    private val userProfileRepository: UserProfileRepository,
    private val phoneNumberUtil: PhoneNumberUtil
) {

    suspend operator fun invoke(phone: String, region: String) : Result {
        val phoneNumber = phoneNumberUtil.parseAndKeepRawInput(phone, region)

        if (region !in phoneNumberUtil.supportedRegions) {
            throw java.lang.IllegalArgumentException("Unsupported region")
        }

        val isValid = phoneNumberUtil.isValidNumberForRegion(phoneNumber, region)
        if (isValid) {
            userProfileRepository.phone = phone
            userProfileRepository.phoneRegion = region
            return Result.Success
        }

        return Result.PhoneValidationError
    }

    sealed interface Result {
        object Success : Result
        object PhoneValidationError : Result
    }
}
