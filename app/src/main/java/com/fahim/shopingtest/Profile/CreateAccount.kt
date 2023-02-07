package com.fahim.shopingtest.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.fahim.shopingtest.API.Api
import com.fahim.shopingtest.Model.SignupUserInput
import com.fahim.shopingtest.R
import com.fahim.shopingtest.databinding.ActivityCreateAccountBinding
import com.fahim.shopingtest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CreateAccount : AppCompatActivity() {

    private lateinit var binding: ActivityCreateAccountBinding

    @Inject
    public lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateAccount.setOnClickListener {
            var signupUserInput = SignupUserInput(
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
            lifecycleScope.launch {
                var response = api.SingUp(signupUserInput)
                Log.e("response", response.body()?.data?.city.toString())
            }
        }

    }
}