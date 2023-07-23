package com.fzco.mango.hand

import com.fzco.mango.data.remote.api.MangoApi
import com.fzco.mango.data.remote.models.registration.RegisterUserBody
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private val service by lazy {
    val interceptor = HttpLoggingInterceptor { message ->
        println(message)
    }
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://plannerok.ru/api/v1/")
        .client(client)
        .build()

    retrofit.create<MangoApi>()
}

fun main() {

    CoroutineScope(Dispatchers.IO).launch {
        while (true) applyNextCommand()
    }

    while (true) {}

}

private suspend fun applyNextCommand() : Unit = when(readln()) {
    "register" -> register()
    else -> Unit
}

private fun input(s: String) : String {
    println(s)
    return readln()
}

private fun String?.puts() {
    this ?: return
    println(this)
}
private fun Any?.puts() {
    toString().puts()
}

suspend fun register() {
    val name = input("Name: ")
    val phone = input("Phone: ")
    val username = input("Username: ")
    val data = RegisterUserBody(name, phone, username)
    service.registerUser(data).body().puts()
}

