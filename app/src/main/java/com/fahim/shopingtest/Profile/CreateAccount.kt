package com.fahim.shopingtest.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.fahim.shopingtest.API.Api
import com.fahim.shopingtest.Model.SignupUserInput
import com.fahim.shopingtest.Profile.viewModel.CreateAccountViewModel
import com.fahim.shopingtest.Profile.viewModel.LoginActivityViewModel
import com.fahim.shopingtest.R
import com.fahim.shopingtest.Utils.NetworkResult
import com.fahim.shopingtest.databinding.ActivityCreateAccountBinding
import com.fahim.shopingtest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateAccount : AppCompatActivity() {

    private lateinit var binding: ActivityCreateAccountBinding

    @Inject
    public lateinit var api: Api
    private val viewModel by viewModels<CreateAccountViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateAccount.setOnClickListener {

            viewModel.singupUser(
                userid = "k4",
                fullname = "ythujlkf",
                email = "helo76r@gmail.com",
                phone = "9988888888",
                password = "9888778",
                gender = "no need",
                address = "no need",
                country = "country",
                city = "city",
                pincode = "pincode"
            )

            viewModel.authResponse.observe(this) {
                when (it) {
                    is NetworkResult.Loading -> {
                        //progress loding
                    }
                    is NetworkResult.Success -> {
                        //progress loding
                    }
                    is NetworkResult.Failure -> {
                        //progress loding
                    }
                }
            }

        }

    }
}