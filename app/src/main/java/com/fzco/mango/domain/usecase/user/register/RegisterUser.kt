package com.fzco.mango.domain.usecase.user.register

import com.fzco.mango.domain.core.service.auth.AuthService
import javax.inject.Inject

class RegisterUser @Inject constructor(
    private val authService: AuthService
) {

    suspend operator fun invoke(
        phone: String,
        name: String,
        username: String
    ) {
        authService.registerUser(name, username, phone)
    }

    sealed interface Result {
        object Success : Result
        object InvalidName : Result
        object InvalidUserName : Result
        object InternalError : Result
    }
}
