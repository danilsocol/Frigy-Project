package com.example.domain.repository

import com.example.domain.dto.ProductRequest
import com.example.domain.models.Product

interface ProductRepository {
    suspend fun getStorageProductById(id: Int): Product
    suspend fun getAllStorageProducts(): List<Product>
    suspend fun createProduct(productRequest: ProductRequest): Product
}