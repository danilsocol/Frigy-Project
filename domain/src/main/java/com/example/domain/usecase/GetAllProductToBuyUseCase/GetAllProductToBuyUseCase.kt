package com.example.domain.usecase.GetAllProductToBuyUseCase

import com.example.domain.models.Product

interface GetAllProductToBuyUseCase {
    suspend fun execute() : List<Product>
}