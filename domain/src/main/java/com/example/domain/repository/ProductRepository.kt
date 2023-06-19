package com.example.domain.repository

import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductRequest
import com.example.domain.models.Product

interface ProductRepository {
    suspend fun getStorageProductById(id: Int): Product
    suspend fun getAllStorageProduct(): List<Product>
    suspend fun createProduct(productCreate: ProductCreate)
    suspend fun updateProduct(productRequest: ProductRequest)
}