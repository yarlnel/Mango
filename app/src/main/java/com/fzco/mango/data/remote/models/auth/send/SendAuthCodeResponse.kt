package com.fzco.mango.data.remote.models.auth.send

import com.google.gson.annotations.SerializedName

data class SendAuthCodeResponse(

    @SerializedName("is_success")
    val isSuccess: Boolean
)