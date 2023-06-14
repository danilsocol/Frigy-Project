package com.example.frigy_project.di

import com.example.data.networks.ProductAPI
import com.example.data.networks.RecipeAPI
import com.example.data.repository.ProductRepositoryImpl
import com.example.data.repository.RecipeRepositoryImpl
import com.example.domain.repository.ProductRepository
import com.example.domain.repository.RecipeRepository
import dagger.Module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {

    private val BASE_URL = "" //todo базовый url

    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun provideRecipeApi(retrofit: Retrofit): RecipeAPI {
        return retrofit.create(RecipeAPI::class.java)
    }
    fun provideProductApi(retrofit: Retrofit): ProductAPI {
        return retrofit.create(ProductAPI::class.java)
    }
    fun provideProductRepository(productAPI: ProductAPI) : ProductRepository {
        return ProductRepositoryImpl(productAPI)
    }
    fun provideRecipeRepository(recipeAPI: RecipeAPI) : RecipeRepository {
        return RecipeRepositoryImpl(recipeAPI)
    }

}