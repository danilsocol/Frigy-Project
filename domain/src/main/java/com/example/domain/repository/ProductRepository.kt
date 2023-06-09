package com.example.domain.repository

import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductStorageRequest
import com.example.domain.dto.ProductToBuyRequest
import com.example.domain.models.Product

interface ProductRepository {
    suspend fun getStorageProductById(id: String): ProductStorageRequest
    suspend fun getAllStorageProducts(): List<ProductStorageRequest>
    suspend fun createProduct(product: ProductCreate): ProductStorageRequest
}