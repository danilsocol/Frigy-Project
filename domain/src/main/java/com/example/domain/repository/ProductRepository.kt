package com.example.domain.repository

import com.example.domain.dto.ProductCreate
import com.example.domain.models.Product

interface ProductRepository {
    suspend fun getStorageProductById(id: String): Product
    suspend fun getAllStorageProducts(): List<Product>
    suspend fun createProduct(product: ProductCreate): Product
}