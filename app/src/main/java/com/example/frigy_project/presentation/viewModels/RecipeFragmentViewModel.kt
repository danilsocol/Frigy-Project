package com.example.frigy_project.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.dto.RecipeCreate
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.models.Recipe
import com.example.domain.models.RecipeCategory
import com.example.domain.usecase.CreateRecipeUseCase.CreateRecipeUseCase
import com.example.domain.usecase.GetAllRecipeUseCase.GetAllRecipeUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecipeFragmentViewModel@Inject constructor(
    private val getAllRecipeUseCase: GetAllRecipeUseCase,
    private val createRecipeUseCase: CreateRecipeUseCase,
) : ViewModel() {

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
        viewModelScope.launch {
            recipesMutable.value = getAllRecipeUseCase.execute()
        }
    }


    fun createRecipe(data : RecipeCreate){
        recipesMutable.value = recipesMutable.value!!.plus(Recipe.getRecipe(data))

        viewModelScope.launch {
            createRecipeUseCase.execute(data)
       }
    }
}
