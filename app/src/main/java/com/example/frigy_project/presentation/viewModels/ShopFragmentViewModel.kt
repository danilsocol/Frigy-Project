package com.example.frigy_project.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.usecase.GetAllRecipeUseCase
import javax.inject.Inject

class ShopFragmentViewModel@Inject constructor() : ViewModel() {

    private var productsMutable = MutableLiveData<List<Product>?>(
        listOf<Product>(
            Product.ProductToBuy( "Молоко", ProductCategory(1,"Жидкость", "литр"), 1,true),
            Product.ProductToBuy("Beer", ProductCategory(1,"Жидкость", "литр"), 2),
            Product.ProductToBuy( "Milk", ProductCategory(1,"Жидкость", "литр"), 4),
        )
    )
    val products : LiveData<List<Product>?>
        get() = productsMutable

    fun init() {
    }

    fun updateItem(item: Product){
        // изменяем данные элемента в списке
    }
}