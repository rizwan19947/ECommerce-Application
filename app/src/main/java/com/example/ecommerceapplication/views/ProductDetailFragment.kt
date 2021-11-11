package com.example.ecommerceapplication.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.models.ProductModel

class ProductDetailFragment : Fragment() {

    private val TAG = "ProductDetailFragment"
    private lateinit var product : ProductModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: "+arguments?.get("product"))
        product = arguments?.get("product") as ProductModel
        return inflater.inflate(R.layout.fragment_product_detail_fragment, container, false)
    }


}