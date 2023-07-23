package com.fzco.mango.data.remote.models.auth.chek

data class CheckAuthCodeBody(
    val code: String,
    val phone: String
)