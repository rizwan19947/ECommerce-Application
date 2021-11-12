package com.example.ecommerceapplication.views

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.*
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
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

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_product_detail_fragment, container, false, null)
        Log.d(TAG, "onCreateView: "+arguments?.get("product"))
        product = arguments?.get("product") as ProductModel

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        assignProductDetails()


        binding.backButton.setOnClickListener {
            gotoMarket()

        }

    }



    private fun assignProductDetails(){


        //Product Detail Images
        Glide.with(requireContext())
                .load(Uri.parse(product.image))
                .into(binding.imageviewWidget)





        binding.nameWidget.setText("Product:\n\n "+ product.title)
        binding.priceWidget.setText("\nPrice: $"+ product.price.toBigDecimal().toString())
        binding.descriptionWidget.setText("\nDescription:\n\n"+ product.description)
        binding.categoryWidget.setText("\nCategory: "+ product.category)
        binding.ratingWidget.setText("\nRating: " + product.rate.toString() + "/5")
        binding.ratingCountWidget.setText("\nNumber of reviews: " + (product.count.toString()))


    }






    override fun openDetails(get: Products) {

    }

    override fun gotoCart() {

    }

    override fun gotoMarket() {
        val action = ProductDetailFragmentDirections.actionProductDetailFragmentToMarketFragment()
        findNavController().navigate(action)
    }


}