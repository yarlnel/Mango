package com.fzco.mango.di.modules.data.network.retrofit

import com.fzco.mango.data.remote.api.MangoApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import timber.log.Timber
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    fun provideHttpLoggingInterceptor() : HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor { message ->
            Timber.tag("OkHttpLog").d(message)
        }

        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ) = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @[Provides Singleton]
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl("https://plannerok.ru/api/v1/")
        .build()

    @[Provides Singleton]
    fun provideApi(retrofit: Retrofit) = retrofit.create<MangoApi>()
}