package com.fzco.mango.domain.usecase.auth

import com.fzco.mango.domain.core.service.auth.IAuthService
import javax.inject.Inject

class RegisterUser @Inject constructor(
    private val authService: IAuthService
) {

    suspend fun invoke(
        name: String,
        username: String,
        phone: String
    ) = authService.registerUser(name, username, phone)
}
