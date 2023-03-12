package com.ther.custom

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RequestsHelper {
    @GET("/")
    suspend fun getUrl() : Response<url>


    @POST("/")
    suspend fun putUrl(@Body requestBody: String) : Response<url>
}