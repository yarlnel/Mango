package com.fzco.mango.data.network.models.profile.get

import com.fzco.mango.data.network.models.profile.common.AvatarFull
import com.google.gson.annotations.SerializedName

data class ProfileData(
    val avatar: String,
    val birthday: String,
    val city: String,
    val created: String,
    val id: Int,
    val instagram: String,
    val last: String,
    val name: String,
    val online: Boolean,
    val phone: String,
    val status: String,
    val username: String,
    val vk: String,

    @SerializedName("completed_task")
    val completedTask: Int,

    @SerializedName("avatars")
    val avatarFull: AvatarFull
)
