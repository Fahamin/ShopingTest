package com.fahim.shopingtest.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.fahim.shopingtest.MainActivity
import com.fahim.shopingtest.Utils.NetworkResult
import com.fahim.shopingtest.Profile.viewModel.LoginActivityViewModel
import com.fahim.shopingtest.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    private val viewModel by viewModels<LoginActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            viewModel.loginRequest(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            )

            viewModel.loginResponse.observe(this) {
                when (it) {
                    is NetworkResult.Loading -> {
                        Toast.makeText(this, "Loding", Toast.LENGTH_SHORT).show()
                    }
                    is NetworkResult.Success -> {
                        Toast.makeText(this, "Login Sussesfull", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))

                    }
                    is NetworkResult.Failure -> {
                        Toast.makeText(this, "Login FAIL", Toast.LENGTH_SHORT).show()

                    }
                }
            }
        }
    }
}