package com.example.domain.usecase.CreateRecipeUseCase

import com.example.domain.dto.ProductRequest
import com.example.domain.dto.RecipeCreate

interface CreateRecipeUseCase {
    suspend fun execute(recipeCreate: RecipeCreate)
}