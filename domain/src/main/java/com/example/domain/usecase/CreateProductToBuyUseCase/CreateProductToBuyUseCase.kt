package com.example.domain.usecase.CreateProductToBuyUseCase

import com.example.domain.dto.ProductToBuyCreate
import com.example.domain.dto.ProductToBuyRequest

interface CreateProductToBuyUseCase {
    suspend fun execute(productToBuyCreate: ProductToBuyCreate)
}