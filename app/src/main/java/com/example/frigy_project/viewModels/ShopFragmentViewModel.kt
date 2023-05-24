package com.example.frigy_project.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frigy_project.models.ListСategories.ProductCategoryList
import com.example.frigy_project.dtos.Product

class ShopFragmentViewModel : ViewModel() {

    private var productsMutable = MutableLiveData<List<Product>?>( )
    val products : LiveData<List<Product>?>
        get() = productsMutable

    fun init() {
        productsMutable.value = listOf<Product>(
            Product.ProductToBuy( "Молоко", ProductCategoryList.productCategoryList[0], 1,true),
            Product.ProductToBuy("Beer", ProductCategoryList.productCategoryList[1], 2),
            Product.ProductToBuy( "Milk", ProductCategoryList.productCategoryList[2], 4),
        )
    }
}