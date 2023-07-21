package com.fzco.mango.data.network.models.auth.chek

data class CheckAuthCodeBody(
    val code: String,
    val phone: String
)