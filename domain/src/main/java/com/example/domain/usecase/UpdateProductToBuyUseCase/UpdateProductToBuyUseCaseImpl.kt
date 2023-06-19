package com.example.domain.usecase.UpdateProductToBuyUseCase

import com.example.domain.dto.ProductRequest
import com.example.domain.repository.ProductRepository
import com.example.domain.repository.ProductToBuyRepository
import javax.inject.Inject

class UpdateProductToBuyUseCaseImpl @Inject constructor(private val productToBuyRepository: ProductToBuyRepository) : UpdateProductToBuyUseCase {
    override suspend fun execute(productRequest: ProductRequest) {
        productToBuyRepository.updateProduct(productRequest)
    }
}