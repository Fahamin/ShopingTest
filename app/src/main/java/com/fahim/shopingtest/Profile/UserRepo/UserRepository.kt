package com.fahim.shopingtest.Profile.UserRepo

import androidx.lifecycle.MutableLiveData
import com.fahim.shopingtest.API.Api
import com.fahim.shopingtest.Model.LoginResponseModel
import com.fahim.shopingtest.Model.LoginUserInput
import com.fahim.shopingtest.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(public var api: Api) {

    suspend fun loginUser(loginUserInput: LoginUserInput) = flow {
        emit(NetworkResult.Loading(true))
        val response = api.singIN(loginUserInput)
        emit(NetworkResult.Success(response))
    }.catch { e ->
        emit(NetworkResult.Failure(e.message ?: "Unknown Error"))
    }


}