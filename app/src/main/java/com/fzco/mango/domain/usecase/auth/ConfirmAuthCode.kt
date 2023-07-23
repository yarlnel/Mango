package com.fzco.mango.domain.usecase.auth

import com.fzco.mango.domain.core.service.auth.IAuthService
import javax.inject.Inject

class ConfirmAuthCode @Inject constructor(
    private val authService: IAuthService
){

    suspend operator fun invoke(
        phone: String,
        authCode: String
    ) = authService.confirmAuthCode(
        phone = phone,
        code = authCode
    )
}
