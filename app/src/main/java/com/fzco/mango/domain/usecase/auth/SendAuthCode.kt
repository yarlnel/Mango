package com.fzco.mango.domain.usecase.auth

import com.fzco.mango.domain.core.service.auth.AuthService
import javax.inject.Inject

class SendAuthCode @Inject constructor(
    private val authService: AuthService
) {

    suspend operator fun invoke(phone: String) =
        authService.requestSendAuthCode(phone)
}