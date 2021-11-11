package com.example.ecommerceapplication.network

import com.example.ecommerceapplication.models.Products
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    fun getProducts (): Call<List<Products>>

}