package com.fzco.mango.presentation.screens.auth.confirm

import com.fzco.mango.presentation.common.viewmodel.contract.ISideEffect

sealed interface ConfirmAuthCodeSideEffect : ISideEffect {

    object ConfirmationError : ConfirmAuthCodeSideEffect
}
