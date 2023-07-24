package com.fzco.mango.presentation.screens.auth.confirm

import com.fzco.mango.presentation.common.viewmodel.contract.IState

data class ConfirmAuthCodeState(
    val phone: String = "",
    val countryCode: String = "",
    val authCode: String = ""
) : IState