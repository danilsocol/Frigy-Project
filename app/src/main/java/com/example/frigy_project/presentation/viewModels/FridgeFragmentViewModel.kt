package com.example.frigy_project.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductRequest
import com.example.domain.dto.ProductUpdate
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.usecase.CreateProductUseCase.CreateProductUseCase
import com.example.domain.usecase.GetAllProductFridgeUseCase.GetAllProductInFridgeUseCase
import com.example.domain.usecase.UpdateProductUseCase.UpdateProductUseCase
import kotlinx.coroutines.launch
import java.security.PrivateKey
import javax.inject.Inject

class FridgeFragmentViewModel@Inject constructor(
    private val getAllProductInFridgeUseCase: GetAllProductInFridgeUseCase,
    private val createProductUseCase: CreateProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase

    ) : ViewModel() {

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
        viewModelScope.launch {
            productsMutable.value = getAllProductInFridgeUseCase.execute()
        }
    }

     fun createProduct(data : ProductCreate){
         productsMutable.value = productsMutable.value!!.plus(Product.getProduct(data))

         viewModelScope.launch {
            createProductUseCase.execute(data)
            }
        }

    fun onAddCountClick(id: Int) {
        val product = productsMutable.value!!.first(){it.id == id}
        product.addCount()
        submitChange(product)
    }

    fun onReduceCountClick(id: Int) {
        val product = productsMutable.value!!.first(){it.id == id}
        product.reduceCount()
        submitChange(product)
    }

    fun onAddMaxCountClick(id: Int) {
        val product = productsMutable.value!!.first(){it.id == id}
        ( product as Product.ImportantProduct).addMaxCount()
        submitChange(product)
    }

    fun onReduceMaxCountClick(id: Int) {
        val product = productsMutable.value!!.first(){it.id == id}
        ( product as Product.ImportantProduct).reduceMaxCount()
        submitChange(product)
    }

    fun submitChange(product : Product){
        val newProduct : ProductUpdate
        if(product !is Product.ImportantProduct)
            newProduct = ProductUpdate(product.id,product.count, null)
        else
            newProduct = ProductUpdate(product.id,product.count, product.maxCount)
        viewModelScope.launch {
            updateProductUseCase.execute(newProduct)
        }
    }
}
