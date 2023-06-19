package com.example.domain.usecase.CreateProductUseCase

import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductRequest

interface CreateProductUseCase {
    suspend fun execute(productCreate: ProductCreate)
}