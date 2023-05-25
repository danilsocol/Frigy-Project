package com.example.frigy_project.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frigy_project.models.ListСategories.ProductCategoryList
import com.example.frigy_project.dtos.Product
import com.example.frigy_project.models.ProductCreate

class FridgeFragmentViewModel : ViewModel() {

    private val productsMutable : MutableLiveData<List<Product>?> by lazy {
        MutableLiveData<List<Product>?>(listOf<Product>(
            Product.DefaultProduct("Молоко", ProductCategoryList.productCategoryList[0],  1),
            Product.DefaultProduct( "Beer", ProductCategoryList.productCategoryList[1],  2),
            Product.DefaultProduct( "Milk", ProductCategoryList.productCategoryList[2],  3),
        ))
    }
    val products : LiveData<List<Product>?>
        get() = productsMutable


    fun init() {

    }

    fun createProduct(data : ProductCreate){
        val product = Product.createProduct(data)
        productsMutable.value = productsMutable.value!!.plus(product)
    }

}