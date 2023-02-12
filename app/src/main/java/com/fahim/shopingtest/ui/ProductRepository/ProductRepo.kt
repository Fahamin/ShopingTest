package com.fahim.shopingtest.ui.ProductRepository

import com.fahim.shopingtest.API.Api
import com.fahim.shopingtest.Model.SignupUserInput
import com.fahim.shopingtest.Utils.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepo @Inject constructor(public var api: Api){

    suspend fun homeImage() = flow {
        emit(NetworkResult.Loading(true))
        val response = api.getHomepageImage()
        emit(NetworkResult.Success(response))
    }.catch { e ->
        emit(NetworkResult.Failure(e.message ?: "Unknown Error"))
    }

}