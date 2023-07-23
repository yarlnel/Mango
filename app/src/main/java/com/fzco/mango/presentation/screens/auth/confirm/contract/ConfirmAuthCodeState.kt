package com.fzco.mango.presentation.screens.auth.confirm.contract

data class ConfirmAuthCodeState(
    val phone: String = "",
    val countryCode: String = "",
    val authCode: String = ""
)