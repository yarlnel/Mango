package com.fzco.mango.data.remote.models.profile.change

import com.fzco.mango.data.remote.models.profile.common.AvatarFull
import com.google.gson.annotations.SerializedName

data class ChangeProfileResponse(

    @SerializedName("avatars")
    val avatarFull: AvatarFull
)
