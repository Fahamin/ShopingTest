package com.fahim.shopingtest.Model

import com.google.gson.annotations.SerializedName

data class HomePageImageModel(

    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("total_image") var totalImage: Int? = null,
    @SerializedName("data") var data: ArrayList<ImageData> = arrayListOf()

)

data class ImageData(

    @SerializedName("_id") var Id: String? = null,
    @SerializedName("imageslider") var imageslider: ArrayList<String> = arrayListOf(),
    @SerializedName("imagestopcategoriesname") var imagestopcategoriesname: ArrayList<String> = arrayListOf(),
    @SerializedName("imagestopcategories") var imagestopcategories: ArrayList<String> = arrayListOf(),
    @SerializedName("imagesfeature") var imagesfeature: ArrayList<String> = arrayListOf(),
    @SerializedName("addedon") var addedon: String? = null

)