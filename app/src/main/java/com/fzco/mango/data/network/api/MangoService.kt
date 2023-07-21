package com.fzco.mango.data.network.api

import com.fzco.mango.data.network.models.auth.chek.CheckAuthCodeBody
import com.fzco.mango.data.network.models.auth.chek.CheckAuthCodeResponse
import com.fzco.mango.data.network.models.registration.RegistrationResponse
import com.fzco.mango.data.network.models.auth.send.SendAuthCodeBody
import com.fzco.mango.data.network.models.auth.send.SendAuthCodeResponse
import com.fzco.mango.data.network.models.profile.change.ChangeProfileBody
import com.fzco.mango.data.network.models.profile.change.ChangeProfileResponse
import com.fzco.mango.data.network.models.profile.get.GetProfileResponse
import com.fzco.mango.data.network.models.registration.RegisterUserBody
import com.fzco.mango.data.network.models.token.refresh.RefreshTokenBody
import com.fzco.mango.data.network.models.token.refresh.RefreshTokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT


interface MangoService {

    @GET("users/check_jwt/")
    suspend fun checkJwt() : Response<String>

    @GET("users/me/")
    suspend fun getProfile() : Response<GetProfileResponse>

    @POST("users/register/")
    suspend fun registerUser(@Body body: RegisterUserBody) : Response<RegistrationResponse>

    @POST("users/check-auth-code/")
    suspend fun checkAuthCode(@Body body: CheckAuthCodeBody) : Response<CheckAuthCodeResponse>

    @POST("users/send-auth-code/")
    suspend fun sendAuthCode(@Body body: SendAuthCodeBody) : Response<SendAuthCodeResponse>

    @POST("users/refresh-token/")
    suspend fun refreshToken(@Body body: RefreshTokenBody) : Response<RefreshTokenResponse>

    @PUT("users/me/")
    suspend fun changeProfile(@Body body: ChangeProfileBody) : Response<ChangeProfileResponse>
}
