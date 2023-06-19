package com.example.domain.usecase.UpdateProductToBuyUseCase

import com.example.domain.dto.ProductRequest

interface UpdateProductToBuyUseCase {
    suspend fun execute(productRequest: ProductRequest)
}