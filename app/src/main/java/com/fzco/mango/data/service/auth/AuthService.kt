package com.fzco.mango.data.service.auth

import com.fzco.mango.data.remote.api.MangoApi
import com.fzco.mango.data.remote.models.auth.chek.CheckAuthCodeBody
import com.fzco.mango.data.remote.models.auth.send.SendAuthCodeBody
import com.fzco.mango.data.remote.models.registration.RegisterUserBody
import com.fzco.mango.domain.core.service.auth.IAuthService
import com.fzco.mango.domain.models.auth.AuthConfirmationInfo
import javax.inject.Inject

class AuthService @Inject constructor(
    private val api: MangoApi
) : IAuthService {

    override suspend fun registerUser(name: String, username: String, phone: String): Boolean {
        val body = RegisterUserBody(name, phone, username)
        val response = api.registerUser(body)
        return response.isSuccessful
    }

    override suspend fun requestSendAuthCode(phone: String): Boolean {
        val body = SendAuthCodeBody(phone)
        val response = api.sendAuthCode(body)
        return response.body()?.isSuccess ?: false
    }

    override suspend fun confirmAuthCode(phone: String, code: String): AuthConfirmationInfo {
        val body = CheckAuthCodeBody(code, phone)
        val response = api.checkAuthCode(body)
        val responseBody = response.body()
        return if (responseBody != null) {
            AuthConfirmationInfo.Result(isUserExists = responseBody.isUserExists)
        } else {
            AuthConfirmationInfo.Error
        }
    }
}

