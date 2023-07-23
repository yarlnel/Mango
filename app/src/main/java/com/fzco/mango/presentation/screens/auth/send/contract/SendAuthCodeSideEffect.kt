package com.fzco.mango.presentation.screens.auth.send.contract

sealed interface SendAuthCodeSideEffect {

    object SendAuthError : SendAuthCodeSideEffect
}
