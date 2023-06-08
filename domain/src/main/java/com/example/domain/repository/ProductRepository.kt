package com.example.domain.repository

import com.example.domain.models.Product

interface ProductRepository {

    suspend fun getProductById(id: String): Product

    suspend fun getAllProducts(): List<Product>

    suspend fun createProduct(product: Product): Product
}