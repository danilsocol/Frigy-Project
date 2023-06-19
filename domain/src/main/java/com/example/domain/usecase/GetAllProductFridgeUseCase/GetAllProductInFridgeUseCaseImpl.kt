package com.example.domain.usecase.GetAllProductFridgeUseCase

import com.example.domain.models.Product
import com.example.domain.repository.ProductRepository
import javax.inject.Inject

class GetAllProductInFridgeUseCaseImpl @Inject constructor(private val productRepository: ProductRepository) : GetAllProductInFridgeUseCase{
    override suspend fun execute() : List<Product>
    {
        return productRepository.getAllStorageProduct()
    }
}