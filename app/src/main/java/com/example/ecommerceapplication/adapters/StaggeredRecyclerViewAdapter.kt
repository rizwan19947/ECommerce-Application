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


class StaggeredRecyclerViewAdapter (val mContext: Context, val mProducts: ArrayList<Products>) : RecyclerView.Adapter<ViewHolder>() {


    private val TAG = "StaggeredRecyclerViewAd"
//    private var mProducts: ArrayList<Products> = ArrayList<Products>()
//    lateinit private var mContext: Context


/*    fun StaggeredRecyclerViewAdapter(context: Context, names: ArrayList<String>, imageUrls: ArrayList<String>) {


    }*/


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


        Glide.with(mContext)
                .load(mProducts.get(position).image)
                .apply(requestOptions)
                .into((holder as GridViewHolder).binding.imageviewWidget)

/*
        holder.name.setText(mNames.get(position))
*/
        holder.setBinding(mProducts.get(position))
        holder.binding.nameWidget.setOnClickListener {
            Log.d(TAG, "onClick: You've clicked on a name of an element")
            Toast.makeText(mContext, "You've clicked on a name of an element", Toast.LENGTH_SHORT)
        }
        holder.binding.imageviewWidget.setOnClickListener {
            Log.d(TAG, "onClick: You've clicked on an image of an element")
            Toast.makeText(mContext, "You've clicked on an image of an element", Toast.LENGTH_SHORT)
        }

    }


}