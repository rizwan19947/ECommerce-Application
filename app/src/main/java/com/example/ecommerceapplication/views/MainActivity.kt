package com.example.ecommerceapplication.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.adapters.StaggeredRecyclerViewAdapter
import com.example.ecommerceapplication.databinding.ActivityMainBinding
import com.example.ecommerceapplication.models.Products
import com.example.ecommerceapplication.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


}