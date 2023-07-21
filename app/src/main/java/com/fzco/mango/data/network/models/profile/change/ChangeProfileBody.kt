package com.fzco.mango.data.network.models.profile.change

import com.fzco.mango.data.network.models.profile.common.Avatar

data class ChangeProfileBody(
    val avatar: Avatar,
    val birthday: String,
    val city: String,
    val instagram: String,
    val name: String,
    val status: String,
    val username: String,
    val vk: String
)
