package com.example.frigy_project.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frigy_project.presentation.models.ListСategories.ProductCategoryList
import com.example.frigy_project.presentation.models.ListСategories.RecipeCategoryList
import com.example.frigy_project.presentation.dtos.Product
import com.example.frigy_project.presentation.dtos.Recipe

class RecipeFragmentViewModel : ViewModel() {
    private var recipesMutable = MutableLiveData<List<Recipe>?>(
        listOf<Recipe>(
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
    )
    val recipes : LiveData<List<Recipe>?>
        get() = recipesMutable

    fun init() {

    }
}