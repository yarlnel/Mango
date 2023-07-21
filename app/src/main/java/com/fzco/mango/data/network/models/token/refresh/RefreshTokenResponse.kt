package com.fzco.mango.data.network.models.token.refresh

import com.google.gson.annotations.SerializedName

data class RefreshTokenResponse(

    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("refresh_token")
    val refreshToken: String,

    @SerializedName("user_id")
    val userId: Int
)
