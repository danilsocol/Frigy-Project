package com.example.frigy_project.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frigy_project.models.ListСategories.ProductCategoryList
import com.example.frigy_project.models.ListСategories.RecipeCategoryList
import com.example.frigy_project.dtos.Product
import com.example.frigy_project.dtos.Recipe

class RecipeFragmentViewModel : ViewModel() {
    private var recipesMutable = MutableLiveData<List<Recipe>?>()
    val recipes : LiveData<List<Recipe>?>
        get() = recipesMutable

    fun init() {
        recipesMutable.value = listOf<Recipe>(
            Recipe( "Суп с молоком", RecipeCategoryList.recipeCategoryList[0],
                listOf(
                    Product.DefaultProduct("Молоко", ProductCategoryList.productCategoryList[0], 1),
                    Product.DefaultProduct("Креветки", ProductCategoryList.productCategoryList[0], 1),
                )
            ),

            Recipe( "Суп с пивом", RecipeCategoryList.recipeCategoryList[1],
                listOf(
                    Product.DefaultProduct( "Пиво", ProductCategoryList.productCategoryList[0], 1),
                    Product.DefaultProduct( "Креветки", ProductCategoryList.productCategoryList[0], 1),
                )
            ),
            Recipe( "test", RecipeCategoryList.recipeCategoryList[2],
                listOf(
                    Product.DefaultProduct("Пиво", ProductCategoryList.productCategoryList[0], 1),
                    Product.DefaultProduct( "Креветки", ProductCategoryList.productCategoryList[0], 1),
                )
            ),
        )
    }
}