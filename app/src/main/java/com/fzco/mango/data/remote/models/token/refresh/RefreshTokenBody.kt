package com.fzco.mango.data.remote.models.token.refresh

import com.google.gson.annotations.SerializedName

data class RefreshTokenBody(

    @SerializedName("refresh_token")
    val refreshToken: String
)