package com.fahim.shopingtest.API

import com.fahim.shopingtest.Model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {

    @POST("user/createaccount")
    suspend fun singUP(@Body singnupUserInput: SignupUserInput): Response<AuthModel>

    @POST("user/login")
    suspend fun singIN(@Body loginUserInput: LoginUserInput): Response<LoginResponseModel>

    @GET("image/")
    suspend fun getHomepageImage(): Response<HomePageImageModel>

    @POST("user/{userid}/addtocart")
    suspend fun addToChart(@Path("userid") uid: String)

}