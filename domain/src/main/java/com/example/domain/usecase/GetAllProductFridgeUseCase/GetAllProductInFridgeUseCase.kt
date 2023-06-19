package com.example.domain.usecase.GetAllProductFridgeUseCase

import com.example.domain.dto.ProductRequest
import com.example.domain.models.Product

interface GetAllProductInFridgeUseCase {
    suspend fun execute() : List<Product>
}