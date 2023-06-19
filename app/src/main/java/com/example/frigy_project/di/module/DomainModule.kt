package com.example.frigy_project.di.module

import com.example.domain.usecase.GetAllProductFridgeUseCase.GetAllProductInFridgeUseCase
import com.example.domain.usecase.GetAllProductFridgeUseCase.GetAllProductInFridgeUseCaseImpl
import com.example.domain.usecase.GetAllRecipeUseCase.GetAllRecipeUseCase
import com.example.domain.usecase.GetAllRecipeUseCase.GetAllRecipeUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DomainModule {

  /*  @Provides
    fun provideGetAllRecipeUseCase(recipeRepository: RecipeRepository): GetAllRecipeUseCaseImpl {
        return GetAllRecipeUseCaseImpl(recipeRepository)
    }*/

    @Binds
    abstract fun provideGetAllRecipeUseCase(getAllRecipeUseCase : GetAllRecipeUseCaseImpl) : GetAllRecipeUseCase

    @Binds
    abstract fun provideGetAllProductUseCase(getAllRecipeUseCase : GetAllProductInFridgeUseCaseImpl) : GetAllProductInFridgeUseCase

}