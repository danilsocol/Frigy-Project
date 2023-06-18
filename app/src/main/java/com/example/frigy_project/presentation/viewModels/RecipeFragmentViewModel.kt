package com.example.frigy_project.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.dto.RecipeCreate
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.models.Recipe
import com.example.domain.models.RecipeCategory
import javax.inject.Inject

class RecipeFragmentViewModel@Inject constructor() : ViewModel() {

    private val recipesMutable : MutableLiveData<List<Recipe>?> by lazy {
        MutableLiveData<List<Recipe>?>(listOf<Recipe>(
            Recipe( 0,"Суп с молоком", "рецепт" , RecipeCategory(1,"Суп"),
                listOf(
                    Product.DefaultProduct(0,"Молоко", ProductCategory(0,"Жидкость", "литр"), 1),
                    Product.DefaultProduct(1,"Креветки", ProductCategory(0,"Жидкость", "литр"), 1),
                )
            )
        ))
    }
    val recipes : LiveData<List<Recipe>?>
        get() = recipesMutable

    fun init() {
        //recipesMutable.value = getAllRecipes.execute()
    }

    fun getRecipeById(id : Int){
        recipesMutable.value!!.filter { it.id == id }
    }

    fun createRecipe(data : RecipeCreate){
        recipesMutable.value = recipesMutable.value!!.plus(Recipe.getRecipe(data)) // todo тестовое


        /*viewModelScope.launch {
           createProductUseCase.execute(data)
           }*/
    }
}

/*
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
)*/
