package com.example.ecommerceapplication.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceapplication.models.Products
import com.example.ecommerceapplication.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private var apiService: ApiService) : ViewModel(){

    private val TAG = "MainViewModel"
//  private var apiService: ApiService
    private var scheduleLiveData: MutableLiveData<List<Products>>? = null


    init{
        scheduleLiveData = MutableLiveData()
//        val retrofitInstance = RetrofitInstance()
//        apiService = retrofitInstance.getRetrofitClient().create(ApiService::class.java)
    }






    fun initData (){

        Log.d(TAG, "initData: Initializing RecycleViewer Data")

        val call: Call<List<Products>> = apiService.getProducts()
        call.enqueue(object: Callback<List<Products>>{
            override fun onResponse(call: Call<List<Products>>, response: Response<List<Products>>) {
                Log.d(TAG, "onResponse: " + response.body())
                scheduleLiveData?.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Products>>, t: Throwable) {
                Log.d(TAG, "onFailure: Failed to retrieve data from the server, please check the internet connection!")
            }

        })



    }

    fun returnLiveData(): MutableLiveData<List<Products>>?{

        return scheduleLiveData



    }




}