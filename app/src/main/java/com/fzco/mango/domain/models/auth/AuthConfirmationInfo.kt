package com.fzco.mango.domain.models.auth

sealed interface AuthConfirmationInfo {

    object Error : AuthConfirmationInfo
    data class Result(
        val isUserExists: Boolean
    ) : AuthConfirmationInfo
}
