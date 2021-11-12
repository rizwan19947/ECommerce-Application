package com.example.ecommerceapplication.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.adapters.StaggeredRecyclerViewAdapter
import com.example.ecommerceapplication.models.ProductModel
import com.example.ecommerceapplication.models.Products

class CartFragment : Fragment(), StaggeredRecyclerViewAdapter.StaggeredInterface {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart_fragment, container, false)







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






    override fun gotoCart() {

    }

    override fun gotoMarket() {

    }

}