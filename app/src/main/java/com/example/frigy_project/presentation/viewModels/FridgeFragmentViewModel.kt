package com.example.frigy_project.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.dto.ProductCreate
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.usecase.CreateProductUseCase.CreateProductUseCase
import com.example.domain.usecase.GetAllProductFridgeUseCase.GetAllProductInFridgeUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FridgeFragmentViewModel@Inject constructor(private val getAllProductInFridgeUseCase: GetAllProductInFridgeUseCase) : ViewModel() {

    private val productsMutable : MutableLiveData<List<Product>?> by lazy {
        MutableLiveData<List<Product>?>(/*listOf<Product>(
            Product.DefaultProduct(0,"Молоко", ProductCategory(0,"Жидкость", "литр"),  1),
            Product.DefaultProduct(1, "Beer", ProductCategory(0,"Жидкость", "литр"),  2),
            Product.DefaultProduct(2, "Milk", ProductCategory(0,"Жидкость", "литр"),  3),
        )*/)
    }
    val products : LiveData<List<Product>?>
        get() = productsMutable

    fun init() {
        viewModelScope.launch {
            productsMutable.value = getAllProductInFridgeUseCase.execute()
        }
    }

     fun createProduct(data : ProductCreate){
         productsMutable.value = productsMutable.value!!.plus(Product.getProduct(data)) // todo тестовое

        /* viewModelScope.launch {
            createProductUseCase.execute(data)
            }*/
        }

    fun onAddCountClick(id: Int) {
        productsMutable.value!!.first(){it.id == id}.addCount()
    }

    fun onReduceCountClick(id: Int) {
        productsMutable.value!!.first(){it.id == id}.reduceCount()
    }

    fun onAddMaxCountClick(id: Int) {
       ( productsMutable.value!!.first(){it.id == id} as Product.ImportantProduct).addMaxCount()
    }

    fun onReduceMaxCountClick(id: Int) {
        ( productsMutable.value!!.first(){it.id == id} as Product.ImportantProduct).reduceMaxCount()
    }
}
