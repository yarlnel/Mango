package com.fzco.mango.data.remote.models.registration

data class RegisterUserBody(
    val name: String,
    val phone: String,
    val username: String
)