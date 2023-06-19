package com.example.domain.usecase.GetAllProductToBuyUseCase

import com.example.domain.models.Product
import com.example.domain.repository.ProductToBuyRepository
import javax.inject.Inject

class GetAllProductToBuyUseCaseImpl@Inject constructor(private val productToBuyRepository: ProductToBuyRepository) :  GetAllProductToBuyUseCase {
    override suspend fun execute(): List<Product> {
        return productToBuyRepository.getAllProductsToBuy()
    }
}