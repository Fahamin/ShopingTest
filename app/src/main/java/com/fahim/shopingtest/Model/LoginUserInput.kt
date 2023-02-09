package com.fahim.shopingtest.Model

import android.provider.ContactsContract.CommonDataKinds.Email
import com.google.gson.annotations.SerializedName

data class LoginUserInput(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
)
