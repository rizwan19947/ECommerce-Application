package com.example.ecommerceapplication

import com.example.ecommerceapplication.network.ApiService
import com.example.ecommerceapplication.network.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiService(retrofitInstance: Retrofit): ApiService{
        return retrofitInstance.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
                .baseUrl( "https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}