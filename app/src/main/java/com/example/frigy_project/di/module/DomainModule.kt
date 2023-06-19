package com.example.frigy_project.di.module

import com.example.domain.usecase.CreateProductToBuyUseCase.CreateProductToBuyUseCase
import com.example.domain.usecase.CreateProductToBuyUseCase.CreateProductToBuyUseCaseImpl
import com.example.domain.usecase.CreateProductUseCase.CreateProductUseCase
import com.example.domain.usecase.CreateProductUseCase.CreateProductUseCaseImpl
import com.example.domain.usecase.CreateRecipeUseCase.CreateRecipeUseCase
import com.example.domain.usecase.CreateRecipeUseCase.CreateRecipeUseCaseImpl
import com.example.domain.usecase.DeleteCheckProductToBuyUseCase.DeleteCheckProductToBuyUseCase
import com.example.domain.usecase.DeleteCheckProductToBuyUseCase.DeleteCheckProductToBuyUseCaseImpl
import com.example.domain.usecase.GetAllProductFridgeUseCase.GetAllProductInFridgeUseCase
import com.example.domain.usecase.GetAllProductFridgeUseCase.GetAllProductInFridgeUseCaseImpl
import com.example.domain.usecase.GetAllProductToBuyUseCase.GetAllProductToBuyUseCase
import com.example.domain.usecase.GetAllProductToBuyUseCase.GetAllProductToBuyUseCaseImpl
import com.example.domain.usecase.GetAllRecipeUseCase.GetAllRecipeUseCase
import com.example.domain.usecase.GetAllRecipeUseCase.GetAllRecipeUseCaseImpl
import com.example.domain.usecase.GetRecipeById.GetRecipeByIdUseCase
import com.example.domain.usecase.GetRecipeById.GetRecipeByIdUseCaseImpl
import com.example.domain.usecase.UpdateProductToBuyUseCase.UpdateProductToBuyUseCase
import com.example.domain.usecase.UpdateProductToBuyUseCase.UpdateProductToBuyUseCaseImpl
import com.example.domain.usecase.UpdateProductUseCase.UpdateProductUseCase
import com.example.domain.usecase.UpdateProductUseCase.UpdateProductUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DomainModule {

    @Binds
    abstract fun provideGetAllRecipeUseCase(getAllRecipeUseCase : GetAllRecipeUseCaseImpl)
    : GetAllRecipeUseCase
    @Binds
    abstract fun provideGetAllProductUseCase(getAllProductInFridgeUseCase : GetAllProductInFridgeUseCaseImpl)
    : GetAllProductInFridgeUseCase
    @Binds
    abstract fun provideGetAllProductToBuyUseCase(getAllProductToBuyUseCase : GetAllProductToBuyUseCaseImpl)
            : GetAllProductToBuyUseCase
    @Binds
    abstract fun provideCreateProductUseCase(createProductUseCase : CreateProductUseCaseImpl)
            : CreateProductUseCase
    @Binds
    abstract fun provideCreateProductToBuyUseCase(createProductToBuyUseCase : CreateProductToBuyUseCaseImpl)
            : CreateProductToBuyUseCase
    @Binds
    abstract fun provideCreateRecipeUseCase(createRecipeUseCase : CreateRecipeUseCaseImpl)
            : CreateRecipeUseCase
    @Binds
    abstract fun provideGetRecipeByIdUseCase(getRecipeByIdUseCase : GetRecipeByIdUseCaseImpl)
            : GetRecipeByIdUseCase
    @Binds
    abstract fun provideDeleteCheckProductToBuyUseCase(deleteCheckProductToBuyUseCase : DeleteCheckProductToBuyUseCaseImpl)
            : DeleteCheckProductToBuyUseCase
    @Binds
    abstract fun provideUpdateProductUseCase(updateProductUseCase : UpdateProductUseCaseImpl)
            : UpdateProductUseCase
    @Binds
    abstract fun provideUpdateProductToBuyUseCase(updateProductToBuyUseCase : UpdateProductToBuyUseCaseImpl)
            : UpdateProductToBuyUseCase
}