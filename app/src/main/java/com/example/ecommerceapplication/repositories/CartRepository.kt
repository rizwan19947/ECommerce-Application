package com.example.ecommerceapplication.repositories

import com.example.ecommerceapplication.models.Products

class CartRepository(products: Products, quantities: Integer) {

    private var product: Products
    private var quantity: Integer

    init {
        product = products
        quantity = quantities
    }


    fun getProduct(): Products {
        return product
    }

    fun getQuantity(): Integer {

        return quantity

    }

    fun setProduct(product: Products){
        this.product = product
    }

    fun setQuantity(quantity: Integer){

        this.quantity = quantity

    }





}