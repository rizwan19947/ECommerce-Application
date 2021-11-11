package com.example.ecommerceapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    fun getRetrofitClient(): Retrofit {

        if (retrofit == null) {

            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

        }

        return retrofit!!
    }

    companion object {

        var retrofit: Retrofit? = null
        private var BASE_URL = "https://fakestoreapi.com/"

    }

}