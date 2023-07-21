package com.fzco.mango.data.network.models.profile.get

import com.google.gson.annotations.SerializedName

data class GetProfileResponse(

    @SerializedName("profile_data")
    val profileData: ProfileData
)
