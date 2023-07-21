package com.fzco.mango.data.network.models.auth.chek

import com.google.gson.annotations.SerializedName

data class CheckAuthCodeResponse(

    @SerializedName("user_id")
    val userId: Int,

    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("is_user_exists")
    val isUserExists: Boolean,

    @SerializedName("refresh_token")
    val refreshToken: String
)
