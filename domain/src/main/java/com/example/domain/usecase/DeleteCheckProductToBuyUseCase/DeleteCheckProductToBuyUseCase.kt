package com.example.domain.usecase.DeleteCheckProductToBuyUseCase

interface DeleteCheckProductToBuyUseCase {
    suspend fun execute(list : List<Int>)
}