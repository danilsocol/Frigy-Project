package com.example.frigy_project.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frigy_project.models.ListСategories.ProductCategoryList
import com.example.frigy_project.dtos.Product
import com.example.frigy_project.models.ProductCreate

class FridgeFragmentViewModel : ViewModel() {

    companion object {
        private var productsMutable = MutableLiveData<List<Product>?>()
    }

    val products : LiveData<List<Product>?>
        get() = productsMutable


    fun init() {
        productsMutable.value = listOf<Product>(
            Product.DefaultProduct("Молоко", ProductCategoryList.productCategoryList[0],  1),
            Product.DefaultProduct( "Beer", ProductCategoryList.productCategoryList[1],  2),
            Product.DefaultProduct( "Milk", ProductCategoryList.productCategoryList[2],  3),
        )
        Log.d("test",productsMutable.value.toString())
    }

    fun createProduct(data : ProductCreate){
        val product = Product.createProduct(data)
        Log.d("test",product.toString())
        Log.d("test", productsMutable.value?.get(0).toString())
        Log.d("test",productsMutable.value.toString())
        Log.d("test",productsMutable.value!!.plus(product).toString())
        productsMutable.value = productsMutable.value!!.plus(product)
        Log.d("test",productsMutable.value.toString())
    }

}