package com.example.frigy_project.api

import com.example.frigy_project.api.request.ProductRequest
import com.example.frigy_project.models.Product

class ProductRepository : ProductAPI {
    override suspend fun getProductById(id: String): Product {
        TODO("Not yet implemented")
    }

    override suspend fun getAllProducts(): List<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun createProduct(productRequest: ProductRequest): Product {
        TODO("Not yet implemented")
    }
}