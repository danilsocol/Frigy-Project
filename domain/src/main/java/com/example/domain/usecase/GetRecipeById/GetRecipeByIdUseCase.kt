package com.example.domain.usecase.GetRecipeById

import com.example.domain.models.Recipe

interface GetRecipeByIdUseCase {
    suspend fun execute(id : Int): Recipe
}