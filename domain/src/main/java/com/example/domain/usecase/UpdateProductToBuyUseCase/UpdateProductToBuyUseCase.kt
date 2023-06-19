package com.example.domain.usecase.UpdateProductToBuyUseCase

import com.example.domain.dto.ProductRequest
import com.example.domain.dto.ProductToBuyUpdate

interface UpdateProductToBuyUseCase {
    suspend fun execute(productToBuyUpdate : ProductToBuyUpdate)
}