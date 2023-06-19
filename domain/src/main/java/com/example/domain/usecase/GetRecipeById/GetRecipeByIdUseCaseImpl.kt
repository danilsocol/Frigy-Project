package com.example.domain.usecase.GetRecipeById

import com.example.domain.models.Recipe
import com.example.domain.repository.RecipeRepository
import javax.inject.Inject

class GetRecipeByIdUseCaseImpl@Inject constructor(private val productRecipeRepository: RecipeRepository) : GetRecipeByIdUseCase {
    override suspend fun execute(id: Int) : Recipe {
        return productRecipeRepository.getRecipeById(id)
    }
}