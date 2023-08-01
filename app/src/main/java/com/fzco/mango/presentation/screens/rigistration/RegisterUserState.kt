package com.fzco.mango.presentation.screens.rigistration

import com.fzco.mango.presentation.common.viewmodel.loading.ILoadingState

data class RegisterUserState(
    val phone: String = "",
    val phoneCountryEmoji: String = "",
    val nameValid: Boolean = true,
    val usernameValid: Boolean = true,
    override var isLoading: Boolean = false
) : ILoadingState
