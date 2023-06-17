package com.example.frigy_project.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductRequest
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import javax.inject.Inject

class FridgeFragmentViewModel@Inject constructor() : ViewModel() {

    private val productsMutable : MutableLiveData<List<Product>?> by lazy {
        MutableLiveData<List<Product>?>(listOf<Product>(
            Product.DefaultProduct(0,"Молоко", ProductCategory(0,"Жидкость", "литр"),  1),
            Product.DefaultProduct(1, "Beer", ProductCategory(0,"Жидкость", "литр"),  2),
            Product.DefaultProduct(2, "Milk", ProductCategory(0,"Жидкость", "литр"),  3),
        ))
    }
    val products : LiveData<List<Product>?>
        get() = productsMutable

    fun init() {

    }

     fun createProduct(data : ProductCreate){
         productsMutable.value = productsMutable.value!!.plus(Product.getProduct(data)) // todo тестовое

         /*viewModelScope.launch {
            createProductUseCase.execute(data)
            }*/
        }
}
