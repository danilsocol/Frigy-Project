package com.example.frigy_project.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.usecase.GetAllRecipeUseCase
import javax.inject.Inject
import javax.inject.Singleton


class ShopFragmentViewModel@Inject constructor() : ViewModel() {

    private val productsMutable : MutableLiveData<List<Product>?> by lazy {
        MutableLiveData<List<Product>?>(listOf<Product>(
            Product.ProductToBuy( "Молоко", ProductCategory(1,"Жидкость", "литр"), 1,true),
            Product.ProductToBuy("Beer", ProductCategory(1,"Жидкость", "литр"), 2),
            Product.ProductToBuy( "Milk", ProductCategory(1,"Жидкость", "литр"), 4),
            Product.ImportantProductToBuy( "Milk", ProductCategory(1,"Жидкость", "литр"), 1, 5),
        ))
    }
    val products : LiveData<List<Product>?>
        get() = productsMutable

    fun init() {
    }


    fun updateSelectedItem(position : Int,product: Product) {
        //todo добавить сохранине в репку
        val productList = productsMutable.value?.toMutableList() ?: return
        productList[position] = product
        productsMutable.value = productList
    }

    companion object {
        var counter: Int = 0

        fun counter(): Int {
            return counter
        }
    }

    init {
        counter++
    }
}