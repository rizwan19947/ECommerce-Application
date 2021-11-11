package com.example.ecommerceapplication.adapters


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.databinding.LayoutGridItemBinding
import com.example.ecommerceapplication.models.Products


class StaggeredRecyclerViewAdapter(val mContext: Context, val mProducts: ArrayList<Products>, val staggeredInterface: StaggeredInterface) : RecyclerView.Adapter<ViewHolder>() {


    private val TAG = "StaggeredRecyclerViewAd"


    class GridViewHolder(var binding: LayoutGridItemBinding) : ViewHolder(binding.root) {

        fun setBinding(product: Products?) {
            binding.product = product
            binding.executePendingBindings()
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {


        val layoutInflater = LayoutInflater.from(parent.getContext())
        val itemTopRatedBinding: LayoutGridItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.layout_grid_item, parent, false)
        return GridViewHolder(itemTopRatedBinding)
    }


    override fun getItemCount(): Int {
        return mProducts.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Log.d(TAG, "onBindViewHolder: onBindViewHolder called")


        var requestOptions: RequestOptions = RequestOptions().placeholder(R.drawable.ic_launcher_background)

        //Images
        Glide.with(mContext)
                .load(mProducts.get(position).image)
                .placeholder(R.mipmap.ic_launcher_round)
                .apply(requestOptions)
                .into((holder as GridViewHolder).binding.imageviewWidget)

        //Prices







        holder.setBinding(mProducts.get(position))

        holder.binding.Card.setOnClickListener {
            Log.d(TAG, "onClick: You've clicked on an element")
            staggeredInterface.openDetails(mProducts.get(position))
            Toast.makeText(mContext, "You've clicked on an element", Toast.LENGTH_SHORT).show()
        }


    }

    interface  StaggeredInterface {
        fun openDetails(get: Products)
    }

}