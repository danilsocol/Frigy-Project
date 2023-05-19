package com.example.frigy_project.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frigy_project.models.ListСategories.ProductCategoryList
import com.example.frigy_project.dtos.Product

class FridgeFragmentViewModel : ViewModel() {

    private var productsMutable = MutableLiveData<List<Product>?>()
    val products : LiveData<List<Product>?>
        get() = productsMutable

    fun init() {
        productsMutable.value = listOf<Product>(
            Product.DefaultProduct(1, "Молоко", ProductCategoryList.productCategoryList[0],  1),
            Product.DefaultProduct(2, "Beer", ProductCategoryList.productCategoryList[1],  2),
            Product.DefaultProduct(3, "Milk", ProductCategoryList.productCategoryList[2],  3),
        )
    }
}