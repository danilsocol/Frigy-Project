package com.example.domain.usecase.GetAllRecipeUseCase

import com.example.domain.models.Recipe
import com.example.domain.repository.RecipeRepository
import javax.inject.Inject

class GetAllRecipeUseCaseImpl @Inject constructor(private val recipeRepository: RecipeRepository): GetAllRecipeUseCase{
    override suspend fun execute() : List<Recipe>{
        return recipeRepository.getAllRecipes()
    }
}