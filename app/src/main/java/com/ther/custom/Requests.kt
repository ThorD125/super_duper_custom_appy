package com.ther.custom

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

suspend fun POST(url: String="https://body.thor-demeestere.workers.dev/",body: String) {
    val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build();


    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(RequestsHelper::class.java)

    val response = apiService.putUrl(body)
}


suspend fun GET(BASE_URL: String = "https://motd.thor-demeestere.workers.dev/"): String{
    return "not working"
//    val okHttpClient: OkHttpClient = OkHttpClient.Builder()
//        .connectTimeout(5, TimeUnit.MINUTES)
//        .readTimeout(30, TimeUnit.SECONDS)
//        .writeTimeout(30, TimeUnit.SECONDS)
//        .build();
//
//
//    val retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .client(okHttpClient)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val apiService = retrofit.create(RequestsHelper::class.java)
//    val response = apiService.getUrl()
//    val result = response.body()?.embeds.toString()
//
//    return result
}
