package com.example.domain.usecase.UpdateProductUseCase

import com.example.domain.dto.ProductRequest
import com.example.domain.dto.ProductUpdate
import com.example.domain.models.Recipe

interface UpdateProductUseCase {
    suspend fun execute(productUpdate: ProductUpdate)
}