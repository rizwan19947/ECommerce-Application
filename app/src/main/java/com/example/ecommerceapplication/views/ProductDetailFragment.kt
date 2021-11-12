package com.example.ecommerceapplication.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.*
import androidx.fragment.app.findFragment
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.adapters.StaggeredRecyclerViewAdapter
import com.example.ecommerceapplication.databinding.FragmentMarketBinding
import com.example.ecommerceapplication.databinding.FragmentProductDetailFragmentBinding
import com.example.ecommerceapplication.models.ProductModel
import com.example.ecommerceapplication.models.Products

class ProductDetailFragment : Fragment(), StaggeredRecyclerViewAdapter.StaggeredInterface {

    private val TAG = "ProductDetailFragment"
    private lateinit var product : ProductModel
    private lateinit var binding: FragmentProductDetailFragmentBinding




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_product_detail_fragment, container, false, null)
        Log.d(TAG, "onCreateView: "+arguments?.get("product"))
        product = arguments?.get("product") as ProductModel

//        return inflater.inflate(R.layout.fragment_product_detail_fragment, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)







        binding.nameWidget.setText(product.title)
        binding.priceWidget.setText(product.price.toBigDecimal().toString())
        binding.descriptionWidget.setText(product.description)
        binding.categoryWidget.setText(product.category)
        binding.ratingWidget.setText(product.rate.toString())
        binding.ratingCountWidget.setText((product.count.toString()))





    }

    override fun openDetails(get: Products) {

    }


}