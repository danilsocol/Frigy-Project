package com.example.domain.usecase

import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductRequest
import com.example.domain.models.Product
import com.example.domain.models.Recipe
import com.example.domain.repository.ProductRepository
import com.example.domain.repository.RecipeRepository
import javax.inject.Inject

class CreateProductUseCase @Inject constructor(private val productRepository: ProductRepository){
    suspend fun execute(productRequest: ProductRequest) {
        productRepository.createProduct(productRequest)
    }
}