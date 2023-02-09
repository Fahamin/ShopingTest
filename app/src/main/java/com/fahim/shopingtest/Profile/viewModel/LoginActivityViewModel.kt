package com.fahim.shopingtest.Profile.viewModel

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahim.shopingtest.API.Api
import com.fahim.shopingtest.Model.LoginResponseModel
import com.fahim.shopingtest.Model.LoginUserInput
import com.fahim.shopingtest.MyApplication
import com.fahim.shopingtest.NetworkResult
import com.fahim.shopingtest.Profile.UserRepo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.reflect.Constructor
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