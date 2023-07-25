package com.fzco.mango.data.remote.models.auth.chek

data class CheckAuthCodeInput(
    val code: String,
    val phone: String
)