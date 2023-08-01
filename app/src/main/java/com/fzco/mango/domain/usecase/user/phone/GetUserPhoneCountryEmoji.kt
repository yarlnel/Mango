package com.fzco.mango.domain.usecase.user.phone

import javax.inject.Inject

class GetUserPhoneCountryEmoji @Inject constructor(
    private val getUserPhoneRegionCode: GetUserPhoneRegionCode
) {

    suspend operator fun invoke() : String {
        val regionCode = getUserPhoneRegionCode()
        val firstLetter = Character.codePointAt(regionCode, 0) - 0x41 + 0x1F1E6
        val secondLetter = Character.codePointAt(regionCode, 1) - 0x41 + 0x1F1E6
        return String(Character.toChars(firstLetter)) + String(Character.toChars(secondLetter))
    }
}
