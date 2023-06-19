package com.example.domain.usecase.GetAllRecipeUseCase

import com.example.domain.models.Recipe

interface GetAllRecipeUseCase {
    suspend fun execute() : List<Recipe>
}