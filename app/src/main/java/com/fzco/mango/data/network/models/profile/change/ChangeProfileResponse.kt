package com.fzco.mango.data.network.models.profile.change

import com.fzco.mango.data.network.models.profile.common.AvatarFull
import com.google.gson.annotations.SerializedName

data class ChangeProfileResponse(

    @SerializedName("avatars")
    val avatarFull: AvatarFull
)
