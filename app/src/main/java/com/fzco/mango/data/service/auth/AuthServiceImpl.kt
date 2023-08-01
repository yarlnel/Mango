package com.fzco.mango.data.service.auth

import com.fzco.mango.data.remote.api.MangoApi
import com.fzco.mango.data.remote.models.auth.chek.CheckAuthCodeInput
import com.fzco.mango.data.remote.models.auth.send.SendAuthCodeInput
import com.fzco.mango.data.remote.models.registration.RegisterUserInput
import com.fzco.mango.domain.core.service.auth.AuthService
import com.fzco.mango.domain.models.auth.AuthConfirmationInfo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import javax.inject.Inject

class AuthServiceImpl @Inject constructor(
    private val api: MangoApi,
    private val gson: Gson
) : AuthService {

    override suspend fun registerUser(name: String, username: String, phone: String): Boolean {
        val input = RegisterUserInput(name, phone, username)
        val response = api.registerUser(input)

        return response.isSuccessful
    }

    override suspend fun requestSendAuthCode(phone: String): Boolean {
        val input = SendAuthCodeInput(phone)
        val response = api.sendAuthCode(input)
        return response.body()?.isSuccess ?: false
    }

    override suspend fun confirmAuthCode(phone: String, code: String): AuthConfirmationInfo {
        val input = CheckAuthCodeInput(code, phone)
        val response = api.checkAuthCode(input)
        val responseBody = response.body()
        return if (responseBody != null) {
            AuthConfirmationInfo.Result(isUserExists = responseBody.isUserExists)
        } else {
            AuthConfirmationInfo.Error
        }
    }
}

