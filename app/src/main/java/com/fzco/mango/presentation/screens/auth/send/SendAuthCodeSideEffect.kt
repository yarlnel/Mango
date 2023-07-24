package com.fzco.mango.presentation.screens.auth.send

import com.fzco.mango.presentation.common.viewmodel.contract.ISideEffect

sealed interface SendAuthCodeSideEffect : ISideEffect {

    object SendAuthError : SendAuthCodeSideEffect
}
