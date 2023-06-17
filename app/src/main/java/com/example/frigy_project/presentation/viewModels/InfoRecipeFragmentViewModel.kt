package com.example.frigy_project.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.models.Recipe
import com.example.domain.models.RecipeCategory
import javax.inject.Inject

class InfoRecipeFragmentViewModel@Inject constructor() : ViewModel() {

    private val recipeMutable : MutableLiveData<Recipe> by lazy {
        MutableLiveData<Recipe>(
            Recipe( 0,"Суп с молоком", "Описания пока что нет" , RecipeCategory(1,"Суп"),
                listOf(
                    Product.DefaultProduct(0,"Молоко", ProductCategory(0,"Жидкость", "литр"), 1),
                    Product.DefaultProduct(1,"Креветки", ProductCategory(0,"Жидкость", "литр"), 1),
                )
            )
        )
    }

    val recipe : LiveData<Recipe>
        get() = recipeMutable
    fun init(id : Int) {
        //recipesMutable.value = getAllRecipes.execute()
    }
}