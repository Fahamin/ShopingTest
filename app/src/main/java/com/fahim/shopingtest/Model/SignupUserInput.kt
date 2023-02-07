package com.fahim.shopingtest.Model

import com.google.gson.annotations.SerializedName

data class SignupUserInput(

    @SerializedName("userid") var userid: String? = null,
    @SerializedName("fullname") var fullname: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("password") var password: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("gender") var gender: String? = null,
    @SerializedName("address") var address: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("pincode") var pincode: String? = null,
)
