package com.example.data.repository

import com.example.data.models.ProductRequestImpl
import com.example.data.networks.ProductAPI
import com.example.domain.dto.ProductRequest
import com.example.domain.models.Product
import com.example.domain.repository.ProductRepository
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(private val productApi : ProductAPI) : ProductRepository { // todo выделить отдельный класс, а репозиторий оставить общим (а может и нет)

    override suspend fun getStorageProductById(id: String): Product {
        val product = productApi.getProductById(id)
        return Product.getProduct(product)
    }

    override suspend fun getAllStorageProducts(): List<Product> {
        return Product.getAllProductStorage( productApi.getAllProducts())
    }

    override suspend fun createProduct(productRequest: ProductRequest): Product {
        val mapProduct = ProductRequestImpl(productRequest.title,productRequest.productCategoryInt,productRequest.isImportant,productRequest.count,productRequest.maxCount) //todo правильно ли мапить из 1 потом обратно?
        val result = productApi.createProduct(mapProduct)
        return Product.getProduct(result)
    }
}