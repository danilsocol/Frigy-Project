package com.example.frigy_project.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.dto.RecipeCreate
import com.example.domain.models.Recipe
import com.example.domain.usecase.CreateRecipeUseCase.CreateRecipeUseCase
import com.example.domain.usecase.GetAllRecipeUseCase.GetAllRecipeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecipeFragmentViewModel @Inject constructor(
    private val getAllRecipeUseCase: GetAllRecipeUseCase,
    private val createRecipeUseCase: CreateRecipeUseCase,
) : ViewModel() {

    private val recipesMutable: MutableLiveData<List<Recipe>?> by lazy {
        MutableLiveData<List<Recipe>?>()
    }
    val recipes: LiveData<List<Recipe>?>
        get() = recipesMutable


    init {
        viewModelScope.launch(Dispatchers.Main) {
            val newRecipes: List<Recipe>
            withContext(Dispatchers.IO) {
                newRecipes = getAllRecipeUseCase.execute()
            }
            recipesMutable.postValue(newRecipes)
        }
    }


    fun createRecipe(data: RecipeCreate) {
        recipesMutable.value = recipesMutable.value!!.plus(Recipe.getRecipe(data))
        viewModelScope.launch(Dispatchers.IO) {
            createRecipeUseCase.execute(data)
        }
    }
}
