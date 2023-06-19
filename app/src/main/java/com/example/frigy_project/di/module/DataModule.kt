package com.example.frigy_project.di.module

import com.example.data.networks.ProductAPI
import com.example.data.networks.ProductToBuyAPI
import com.example.data.networks.RecipeAPI
import com.example.data.repository.ProductRepositoryImpl
import com.example.data.repository.ProductToBuyRepositoryImpl
import com.example.data.repository.RecipeRepositoryImpl
import com.example.domain.repository.ProductRepository
import com.example.domain.repository.ProductToBuyRepository
import com.example.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
abstract class DataModule {

    companion object {

        private val BASE_URL = "http://10.0.2.2:5235"
        @Provides
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        @Provides
        fun provideRecipeApi(retrofit: Retrofit): RecipeAPI {
            return retrofit.create(RecipeAPI::class.java)
        }

        @Provides
        fun provideProductApi(retrofit: Retrofit): ProductAPI {
            return retrofit.create(ProductAPI::class.java)
        }

        @Provides
        fun provideProductToBuyApi(retrofit: Retrofit): ProductToBuyAPI {
            return retrofit.create(ProductToBuyAPI::class.java)
        }
    }
    @Binds
    abstract fun provideProductRepository(productRepositoryImpl: ProductRepositoryImpl) : ProductRepository
    @Binds
    abstract fun provideRecipeRepository(recipeRepositoryImpl: RecipeRepositoryImpl) : RecipeRepository
    @Binds
    abstract fun provideProductToBuyRepository(productToBuyRepositoryImpl: ProductToBuyRepositoryImpl) : ProductToBuyRepository
}