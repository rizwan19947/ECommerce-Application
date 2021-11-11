package com.example.ecommerceapplication.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.adapters.StaggeredRecyclerViewAdapter
import com.example.ecommerceapplication.databinding.ActivityMainBinding
import com.example.ecommerceapplication.models.Products
import com.example.ecommerceapplication.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val COLUMN_NUMBER  = 2
    private lateinit var sAdapter: StaggeredRecyclerViewAdapter
    private lateinit var sGridLayoutManager: StaggeredGridLayoutManager



    lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private var arrList: ArrayList<Products> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.initData()

        mainViewModel.returnLiveData()?.observe(this,{

            arrList = it as ArrayList<Products>
            sAdapter = StaggeredRecyclerViewAdapter(this, arrList)
            sGridLayoutManager = StaggeredGridLayoutManager(COLUMN_NUMBER, LinearLayoutManager.VERTICAL)
            binding.recyclerView.layoutManager = sGridLayoutManager
            binding.recyclerView.adapter = sAdapter

        })


    }


}