package com.example.frigy_project.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frigy_project.models.ListСategories.ProductCategoryList
import com.example.frigy_project.models.ListСategories.RecipeCategoryList
import com.example.frigy_project.models.Product
import com.example.frigy_project.models.Recipe

class RecipeFragmentViewModel : ViewModel() {
    private var recipesMutable = MutableLiveData<List<Recipe>?>()
    val recipes : LiveData<List<Recipe>?>
        get() = recipesMutable

    fun init() {
        recipesMutable.value = listOf<Recipe>(
            Recipe(1, "Суп с молоком", RecipeCategoryList.recipeCategoryList[0],
                listOf(
                    Product.DefaultProduct(1, "Молоко", ProductCategoryList.productCategoryList[0], 1),
                    Product.DefaultProduct(2, "Креветки", ProductCategoryList.productCategoryList[0], 1),
                )
            ),

            Recipe(2, "Суп с пивом", RecipeCategoryList.recipeCategoryList[1],
                listOf(
                    Product.DefaultProduct(1, "Пиво", ProductCategoryList.productCategoryList[0], 1),
                    Product.DefaultProduct(2, "Креветки", ProductCategoryList.productCategoryList[0], 1),
                )
            ),
            Recipe(2, "test", RecipeCategoryList.recipeCategoryList[2],
                listOf(
                    Product.DefaultProduct(1, "Пиво", ProductCategoryList.productCategoryList[0], 1),
                    Product.DefaultProduct(2, "Креветки", ProductCategoryList.productCategoryList[0], 1),
                )
            ),
        )
    }
}