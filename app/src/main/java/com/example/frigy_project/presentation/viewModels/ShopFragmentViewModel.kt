package com.example.frigy_project.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Product

class ShopFragmentViewModel : ViewModel() {

    private var productsMutable = MutableLiveData<List<Product>?>(
      /*  listOf<Product>(
            Product.ProductToBuy( "Молоко", ProductCategoryList.productCategoryList[0], 1,true),
            Product.ProductToBuy("Beer", ProductCategoryList.productCategoryList[1], 2),
            Product.ProductToBuy( "Milk", ProductCategoryList.productCategoryList[2], 4),
        )*/
    )
    val products : LiveData<List<Product>?>
        get() = productsMutable

    fun init() {
    }

    fun updateItem(item: Product){
        // изменяем данные элемента в списке
    }
}