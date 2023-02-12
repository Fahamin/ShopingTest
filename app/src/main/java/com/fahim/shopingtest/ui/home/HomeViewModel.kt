package com.fahim.shopingtest.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.fahim.shopingtest.Model.HomePageImageModel
import com.fahim.shopingtest.Model.LoginResponseModel
import com.fahim.shopingtest.Profile.UserRepo.UserRepository
import com.fahim.shopingtest.Utils.NetworkResult
import com.fahim.shopingtest.ui.ProductRepository.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    var productRepo: ProductRepo
) : ViewModel() {

    var imageResponse = MutableLiveData<NetworkResult<Response<HomePageImageModel>>>()

    init {
        viewModelScope.launch {
            productRepo.homeImage().collect() {
                imageResponse.postValue(it)
                Log.e("respon", it.toString())
            }
        }
    }

}