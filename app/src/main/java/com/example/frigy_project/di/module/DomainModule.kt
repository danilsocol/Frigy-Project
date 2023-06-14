package com.example.frigy_project.di.module

import com.example.domain.repository.RecipeRepository
import com.example.domain.usecase.GetAllRecipeUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetAllRecipeUseCase(recipeRepository: RecipeRepository): GetAllRecipeUseCase {
        return GetAllRecipeUseCase(recipeRepository)
    }

}