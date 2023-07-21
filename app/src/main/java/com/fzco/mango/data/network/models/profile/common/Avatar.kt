package com.fzco.mango.data.network.models.profile.common

import com.google.gson.annotations.SerializedName

data class Avatar(

    @SerializedName("base_64")
    val base64: String,
    val filename: String
)
