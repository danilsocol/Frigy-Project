package com.example.domain.repository

import com.example.domain.dto.ProductRequest
import com.example.domain.dto.ProductToBuyCreate
import com.example.domain.models.Product

interface ProductToBuyRepository {

    suspend fun getAllProductsToBuy(): List<Product>
    suspend fun deleteAllCheckProduct(list : List<Int>)
    suspend fun createProduct(productToBuyCreate: ProductToBuyCreate)
    suspend fun updateProduct(productRequest: ProductRequest)
}