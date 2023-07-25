package com.fzco.mango.data.remote.models.token.refresh

import com.google.gson.annotations.SerializedName

data class RefreshTokenInput(

    @SerializedName("refresh_token")
    val refreshToken: String
)