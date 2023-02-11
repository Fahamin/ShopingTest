package com.fahim.shopingtest.Profile.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahim.shopingtest.Model.LoginResponseModel
import com.fahim.shopingtest.Model.LoginUserInput
import com.fahim.shopingtest.Utils.NetworkResult
import com.fahim.shopingtest.Profile.UserRepo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginActivityViewModel @Inject constructor(
    var userRepository: UserRepository,
) : ViewModel() {

    var loginResponse = MutableLiveData<NetworkResult<Response<LoginResponseModel>>>()

    fun loginRequest(email: String, password: String) {
        var loginUserInput = LoginUserInput(
            email = email,
            password = password
        )

        viewModelScope.launch {
            userRepository.loginUser(loginUserInput).collect() {
                loginResponse.postValue(it)
            }

        }
    }

}