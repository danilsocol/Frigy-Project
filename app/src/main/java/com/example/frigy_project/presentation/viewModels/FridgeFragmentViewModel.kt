package com.example.frigy_project.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductUpdate
import com.example.domain.models.Product
import com.example.domain.usecase.CreateProductUseCase.CreateProductUseCase
import com.example.domain.usecase.GetAllProductFridgeUseCase.GetAllProductInFridgeUseCase
import com.example.domain.usecase.UpdateProductUseCase.UpdateProductUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FridgeFragmentViewModel @Inject constructor(
    private val getAllProductInFridgeUseCase: GetAllProductInFridgeUseCase,
    private val createProductUseCase: CreateProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase

) : ViewModel() {

    private val productsMutable: MutableLiveData<List<Product>?> by lazy {
        MutableLiveData<List<Product>?>()
    }
    val products: LiveData<List<Product>?>
        get() = productsMutable

    init {
        viewModelScope.launch(Dispatchers.Main) {
            val newProducts: List<Product>
            withContext(Dispatchers.IO) {
                newProducts = getAllProductInFridgeUseCase.execute()
            }
            productsMutable.postValue(newProducts)
        }
    }

    fun createProduct(data: ProductCreate) {
        productsMutable.value = productsMutable.value!!.plus(Product.getProduct(data))

        viewModelScope.launch(Dispatchers.IO) {
            createProductUseCase.execute(data)
        }
    }

    fun onAddCountClick(id: Int) {
        val product = productsMutable.value!!.first { it.id == id }
        product.addCount()
        submitChange(product)
    }

    fun onReduceCountClick(id: Int) {
        val product = productsMutable.value!!.first { it.id == id }
        product.reduceCount()
        submitChange(product)
    }

    fun onAddMaxCountClick(id: Int) {
        val product = productsMutable.value!!.first { it.id == id }
        (product as Product.ImportantProduct).addMaxCount()
        submitChange(product)
    }

    fun onReduceMaxCountClick(id: Int) {
        val product = productsMutable.value!!.first { it.id == id }
        (product as Product.ImportantProduct).reduceMaxCount()
        submitChange(product)
    }

    private fun submitChange(product: Product) {
        val newProduct: ProductUpdate = if (product !is Product.ImportantProduct)
            ProductUpdate(product.id, product.count, null)
        else
            ProductUpdate(product.id, product.count, product.maxCount)
        viewModelScope.launch(Dispatchers.IO) {
            updateProductUseCase.execute(newProduct)
        }
    }
}
