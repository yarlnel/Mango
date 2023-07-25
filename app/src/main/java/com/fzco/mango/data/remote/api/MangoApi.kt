package com.fzco.mango.data.remote.api

import com.fzco.mango.data.remote.models.auth.chek.CheckAuthCodeInput
import com.fzco.mango.data.remote.models.auth.chek.CheckAuthCodeResponse
import com.fzco.mango.data.remote.models.registration.RegistrationResponse
import com.fzco.mango.data.remote.models.auth.send.SendAuthCodeInput
import com.fzco.mango.data.remote.models.auth.send.SendAuthCodeResponse
import com.fzco.mango.data.remote.models.profile.change.ChangeProfileInput
import com.fzco.mango.data.remote.models.profile.change.ChangeProfileResponse
import com.fzco.mango.data.remote.models.profile.get.GetProfileResponse
import com.fzco.mango.data.remote.models.registration.RegisterUserInput
import com.fzco.mango.data.remote.models.token.refresh.RefreshTokenInput
import com.fzco.mango.data.remote.models.token.refresh.RefreshTokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT


interface MangoApi {

    @GET("users/check_jwt/")
    suspend fun checkJwt() : Response<String>

    @GET("users/me/")
    suspend fun getProfile() : Response<GetProfileResponse>

    @POST("users/register/")
    suspend fun registerUser(@Body input: RegisterUserInput) : Response<RegistrationResponse>

    @POST("users/check-auth-code/")
    suspend fun checkAuthCode(@Body input: CheckAuthCodeInput) : Response<CheckAuthCodeResponse>

    @POST("users/send-auth-code/")
    suspend fun sendAuthCode(@Body input: SendAuthCodeInput) : Response<SendAuthCodeResponse>

    @POST("users/refresh-token/")
    suspend fun refreshToken(@Body input: RefreshTokenInput) : Response<RefreshTokenResponse>

    @PUT("users/me/")
    suspend fun changeProfile(@Body input: ChangeProfileInput) : Response<ChangeProfileResponse>
}
