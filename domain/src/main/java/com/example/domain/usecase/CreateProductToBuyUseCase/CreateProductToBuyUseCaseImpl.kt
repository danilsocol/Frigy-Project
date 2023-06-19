package com.example.domain.usecase.CreateProductToBuyUseCase

import com.example.domain.dto.ProductRequest
import com.example.domain.dto.ProductToBuyCreate
import com.example.domain.dto.ProductToBuyRequest
import com.example.domain.repository.ProductToBuyRepository
import javax.inject.Inject

class CreateProductToBuyUseCaseImpl @Inject constructor(private val productToBuyRepository: ProductToBuyRepository) : CreateProductToBuyUseCase{

    override suspend fun execute(productToBuyCreate: ProductToBuyCreate) {
        productToBuyRepository.createProduct(productToBuyCreate)
    }
}