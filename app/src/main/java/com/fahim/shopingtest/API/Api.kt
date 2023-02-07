package com.fahim.shopingtest.API

import com.fahim.shopingtest.Model.AuthModel
import com.fahim.shopingtest.Model.LoginUserInput
import com.fahim.shopingtest.Model.SignupUserInput
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST("user/createaccount")
    suspend fun SingUp(@Body singnupUserInput: SignupUserInput): Response<AuthModel>

}