package com.example.domain.usecase.UpdateProductUseCase

import com.example.domain.dto.ProductRequest
import com.example.domain.dto.ProductUpdate
import com.example.domain.repository.ProductRepository
import javax.inject.Inject

class UpdateProductUseCaseImpl @Inject constructor(private val productRepository: ProductRepository): UpdateProductUseCase {
    override suspend fun execute(productUpdate: ProductUpdate) {
        productRepository.updateProduct(productUpdate)
    }
}