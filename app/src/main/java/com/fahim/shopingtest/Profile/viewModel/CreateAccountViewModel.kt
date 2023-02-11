package com.fahim.shopingtest.Profile.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahim.shopingtest.Model.AuthModel
import com.fahim.shopingtest.Model.LoginResponseModel
import com.fahim.shopingtest.Model.LoginUserInput
import com.fahim.shopingtest.Model.SignupUserInput
import com.fahim.shopingtest.Profile.UserRepo.UserRepository
import com.fahim.shopingtest.Utils.NetworkResult
import com.google.gson.annotations.SerializedName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class CreateAccountViewModel @Inject constructor(var userRepository: UserRepository) : ViewModel() {
    init {

    }

    var authResponse = MutableLiveData<NetworkResult<Response<AuthModel>>>()

    fun singupUser(
        userid: String,
        fullname: String,
        email: String,
        password: String,
        phone: String,
        gender: String,
        address: String,
        country: String,
        city: String,
        pincode: String,
    ) {
        var signupUserInput = SignupUserInput(
            email = email,
            password = password,
            userid = userid,
            fullname = fullname,
            phone = phone,
            gender = gender,
            address = address,
            country = country,
            city = city,
            pincode = pincode
        )

        viewModelScope.launch {
            userRepository.createAccount(signupUserInput).collect() {
                authResponse.postValue(it)
            }

        }
    }

}