package com.example.ecommerceapplication.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class Products(@SerializedName("id") val id : Int,
                    @SerializedName("title") val title : String,
                    @SerializedName("price") val price : Double,
                    @SerializedName("description") val description : String,
                    @SerializedName("category") val category : String,
                    @SerializedName("image") val image : String,
                    @SerializedName("rating") val rating : Rating)

