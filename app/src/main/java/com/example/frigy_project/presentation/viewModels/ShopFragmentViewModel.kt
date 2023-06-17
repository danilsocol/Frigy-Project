package com.example.frigy_project.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductToBuyCreate
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import javax.inject.Inject


class ShopFragmentViewModel@Inject constructor() : ViewModel() {

    private val productsMutable : MutableLiveData<List<Product>?> by lazy {
        MutableLiveData<List<Product>?>(listOf<Product>(
            Product.ProductToBuy( 0,"Молоко", ProductCategory(0,"Жидкость", "литр"), 1,true),
            Product.ProductToBuy(1,"Beer", ProductCategory(0,"Жидкость", "литр"), 2),
            Product.ProductToBuy( 2,"Milk", ProductCategory(0,"Жидкость", "литр"), 4),
            Product.ImportantProductToBuy(3, "Milk", ProductCategory(0,"Жидкость", "литр"), 1, 5),
        ))
    }
    val products : LiveData<List<Product>?>
        get() = productsMutable

    fun init() {
    }


    fun updateSelectedItem(position : Int,product: Product) { //todo обновляется весь список в адаптере или как?
        //todo добавить сохранине в репку
        val productList = productsMutable.value?.toMutableList() ?: return
        productList[position] = product
        productsMutable.value = productList
    }

    fun createProduct(data : ProductToBuyCreate){
        productsMutable.value = productsMutable.value!!.plus(Product.getProductToBuy(data)) // todo тестовое

        /*viewModelScope.launch {
           createProductUseCase.execute(data)
           }*/
    }
}