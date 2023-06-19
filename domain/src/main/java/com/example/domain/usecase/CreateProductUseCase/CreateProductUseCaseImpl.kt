package com.example.domain.usecase.CreateProductUseCase

import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductRequest
import com.example.domain.repository.ProductRepository
import javax.inject.Inject

class CreateProductUseCaseImpl @Inject constructor(private val productRepository: ProductRepository) : CreateProductUseCase{
    override suspend fun execute(productCreate: ProductCreate) {
        productRepository.createProduct(productCreate)
    }
}