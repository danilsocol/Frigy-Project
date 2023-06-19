package com.example.domain.usecase.DeleteCheckProductToBuyUseCase

import com.example.domain.repository.ProductToBuyRepository
import javax.inject.Inject

class DeleteCheckProductToBuyUseCaseImpl @Inject constructor(private val productToBuyRepository: ProductToBuyRepository): DeleteCheckProductToBuyUseCase {
    override suspend fun execute(list: List<Int>) {
        productToBuyRepository.deleteAllCheckProduct(list)
    }
}