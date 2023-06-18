package com.fahim.shopingtest.API

import com.fahim.shopingtest.Model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @POST("user/createaccount")
    suspend fun singUP(@Body singnupUserInput: SignupUserInput): Response<AuthModel>

    @POST("user/login")
    suspend fun singIN(@Body loginUserInput: LoginUserInput): Response<LoginResponseModel>

    @GET("image/")
    suspend fun getHomepageImage(): Response<HomePageImageModel>

    @POST("user/{userid}/addtocart")
    suspend fun addToChart(@Path("userid") uid: String)


    @Headers("Content-Type: application/json; charset=utf-8")
    @FormUrlEncoded
    @POST("/api/ApiCheckUser/ApiCheckUser")
    suspend fun getLoginInfo(
        @FieldMap param: HashMap<String?, String?>?,
        @Header("Authorization") authorization: String?
    ): Response<HomePageImageModel>


    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("/api/ApiSyncPromotation/ApiGetTradePromotionNew?")
    suspend fun getOfferList(
        @Header("Authorization") authorization: String?,
        @Query("dbid") id: String?,
        @Query("psrid") psrid: String?,
        @Query("token") token: String?
    ):Response<HomePageImageModel>

    @Headers("Content-Type: application/json; charset=utf-8")
    @POST("/api/ApiSyncUpNewOutlet/ApiSyncEdsOutlet")
    suspend fun sendEditOutletSync(
        @Header("Authorization") authorization: String?,
        @Body body: String?
    ): Response<HomePageImageModel>


}