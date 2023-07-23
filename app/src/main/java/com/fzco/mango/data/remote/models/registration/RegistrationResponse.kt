package com.fzco.mango.data.remote.models.registration

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("refresh_token")
    val refreshToken: String,

    @SerializedName("user_id")
    val userId: Int
)