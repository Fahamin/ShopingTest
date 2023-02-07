package com.fahim.shopingtest.Model

import com.google.gson.annotations.SerializedName

data class AuthModel(

    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("data") var data: Data? = Data()

)

data class Data(

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
    @SerializedName("token") var token: String? = null,
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("addedon") var addedon: String? = null

)


