package com.example.ecommerceapplication.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.adapters.StaggeredRecyclerViewAdapter
import com.example.ecommerceapplication.databinding.FragmentMarketBinding
import com.example.ecommerceapplication.models.ProductModel
import com.example.ecommerceapplication.models.Products
import com.example.ecommerceapplication.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MarketFragment : Fragment(), StaggeredRecyclerViewAdapter.StaggeredInterface {

    private lateinit var sAdapter: StaggeredRecyclerViewAdapter
    private lateinit var sGridLayoutManager: StaggeredGridLayoutManager
    private val COLUMN_NUMBER = 2
    private val mainViewModel: MainViewModel by viewModels()
    private var arrList: ArrayList<Products> = ArrayList()

    private lateinit var binding: FragmentMarketBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_market, container, false, null)
        binding.progressBar.visibility = View.VISIBLE
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mainViewModel.initData()

        mainViewModel.returnLiveData()?.observe(this, {


            arrList = it as ArrayList<Products>
            sAdapter = StaggeredRecyclerViewAdapter(requireContext(), arrList, this)
            sGridLayoutManager = StaggeredGridLayoutManager(COLUMN_NUMBER, LinearLayoutManager.VERTICAL)
            binding.recyclerView.layoutManager = sGridLayoutManager
            binding.recyclerView.adapter = sAdapter
            binding.progressBar.visibility = View.GONE

        })

    }

    override fun openDetails(get: Products) {
        val product = ProductModel(
                get.id,
                get.title,
                get.price,
                get.description,
                get.category,
                get.image,
                get.rating.rate,
                get.rating.count
        )
        val action = MarketFragmentDirections.actionMarketFragmentToProductDetailFragment(product)
        findNavController().navigate(action)
    }

}