package com.fzco.mango.domain.usecase.auth

import com.fzco.mango.domain.core.service.auth.AuthService
import javax.inject.Inject

class RegisterUser @Inject constructor(
    private val authService: AuthService
) {

    suspend fun invoke(
        name: String,
        username: String,
        phone: String
    ) = authService.registerUser(name, username, phone)
}
