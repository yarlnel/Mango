package com.fzco.mango.presentation.screens.rigistration

import com.fzco.mango.presentation.common.viewmodel.contract.ISideEffect

sealed interface RegisterUserSideEffect : ISideEffect {

    object NameNotValid : RegisterUserSideEffect
    object UsernameNotValid : RegisterUserSideEffect
    object InternalServerError : RegisterUserSideEffect
}
