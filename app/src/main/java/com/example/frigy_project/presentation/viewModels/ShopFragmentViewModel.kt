package com.example.frigy_project.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductToBuyCreate
import com.example.domain.dto.ProductToBuyUpdate
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.usecase.CreateProductToBuyUseCase.CreateProductToBuyUseCase
import com.example.domain.usecase.CreateProductUseCase.CreateProductUseCase
import com.example.domain.usecase.GetAllProductToBuyUseCase.GetAllProductToBuyUseCase
import com.example.domain.usecase.UpdateProductToBuyUseCase.UpdateProductToBuyUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


class ShopFragmentViewModel@Inject constructor(
    private val createProductToBuyUseCase: CreateProductToBuyUseCase,
    private val getAllProductToBuyUseCase: GetAllProductToBuyUseCase,
    private val updateProductToBuyUseCase: UpdateProductToBuyUseCase
) : ViewModel() {

    private val productsMutable : MutableLiveData<List<Product>?> by lazy {
        MutableLiveData<List<Product>?>()
    }
    val products : LiveData<List<Product>?>
        get() = productsMutable

    init {
        viewModelScope.launch {
            productsMutable.value = getAllProductToBuyUseCase.execute()
        }
    }

    fun updateSelectedItem(position : Int,product: Product) {
        val productList = productsMutable.value?.toMutableList() ?: return
        productList[position] = product
        productsMutable.value = productList

        viewModelScope.launch {
            updateProductToBuyUseCase.execute(ProductToBuyUpdate(product.id,
                (product is Product.ProductToBuy && product.isBuy || product is Product.ImportantProductToBuy && product.isBuy)))
        }
    }

    fun createProduct(data : ProductToBuyCreate){
        productsMutable.value = productsMutable.value!!.plus(Product.getProductToBuy(data))

        viewModelScope.launch {
            createProductToBuyUseCase.execute(data)
           }
    }

    fun buyProduct(){
        productsMutable.value = productsMutable.value?.filter {
            !(it is Product.ProductToBuy && it.isBuy || it is Product.ImportantProductToBuy && it.isBuy)
        }
    }
}