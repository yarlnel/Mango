package com.fzco.mango.domain.usecase.auth

import com.fzco.mango.domain.core.service.auth.IAuthService
import javax.inject.Inject

class SendAuthCode @Inject constructor(
    private val authService: IAuthService
) {

    suspend operator fun invoke(phone: String) =
        authService.requestSendAuthCode(phone)
}