package com.fzco.mango.presentation.screens.rigistration

import com.fzco.mango.presentation.common.viewmodel.contract.IState

data class RegisterUserState(
    val phone: String = "",
    val phoneCountryEmoji: String = ""
) : IState
