package com.fzco.mango.data.network.models.registration

data class RegisterUserBody(
    val name: String,
    val phone: String,
    val username: String
)