package com.example.domain.usecase.CreateRecipeUseCase

import com.example.domain.dto.RecipeCreate
import com.example.domain.repository.RecipeRepository
import javax.inject.Inject

class CreateRecipeUseCaseImpl@Inject constructor(private val recipeRepository: RecipeRepository) : CreateRecipeUseCase {
    override suspend fun execute(recipeCreate: RecipeCreate) {
        recipeRepository.createRecipe(recipeCreate)
    }
}