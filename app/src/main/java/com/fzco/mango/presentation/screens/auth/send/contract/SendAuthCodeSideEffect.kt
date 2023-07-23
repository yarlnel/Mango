package com.fzco.mango.presentation.screens.auth.send.contract

import com.fzco.mango.presentation.common.viewmodel.contract.ISideEffect

sealed interface SendAuthCodeSideEffect : ISideEffect {

    object SendAuthError : SendAuthCodeSideEffect
}
