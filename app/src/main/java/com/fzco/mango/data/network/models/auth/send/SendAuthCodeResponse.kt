package com.fzco.mango.data.network.models.auth.send

import com.google.gson.annotations.SerializedName

data class SendAuthCodeResponse(

    @SerializedName("is_success")
    val isSuccess: Boolean
)