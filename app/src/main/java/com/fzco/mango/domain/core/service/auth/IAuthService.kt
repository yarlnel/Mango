package com.fzco.mango.domain.core.service.auth

import com.fzco.mango.domain.models.auth.AuthConfirmationInfo

interface IAuthService {

    suspend fun registerUser(
        name: String,
        username: String,
        phone: String
    ) : Boolean

    suspend fun requestSendAuthCode(phone: String) : Boolean
    suspend fun confirmAuthCode(phone: String, code: String) : AuthConfirmationInfo
}
