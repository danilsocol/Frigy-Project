package com.example.domain.usecase

import com.example.domain.models.Recipe
import com.example.domain.repository.RecipeRepository
import javax.inject.Inject

class GetAllRecipeUseCase @Inject constructor(private val recipeRepository: RecipeRepository){
    suspend fun execute() : List<Recipe>{
        return recipeRepository.getAllRecipes()
    }
}