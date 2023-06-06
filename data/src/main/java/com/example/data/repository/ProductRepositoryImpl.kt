package com.example.data.repository

import com.example.data.models.ProductRequest
import com.example.data.networks.ProductAPI
import com.example.data.retrofit.RetrofitBuilder
import com.example.domain.models.Product
import com.example.domain.repository.ProductRepository


class ProductRepositoryImpl : ProductRepository { // todo выделить отдельный класс, а репозиторий оставить общим (а может и нет)

    private val retrofit = RetrofitBuilder.getClient()
    private val productApi = retrofit!!.create(ProductAPI::class.java)

    override suspend fun getProductById(id: String): Product {
        val product = productApi.getProductById(id)
        return Product(product.name,product.productCategory,product.isImportant,product.count,product.maxCount)
    }

    override suspend fun getAllProducts(): List<Product> {
        return productApi.getAllProducts().map { product -> Product(product.name,product.productCategory,product.isImportant,product.count,product.maxCount) }
    }

    override suspend fun createProduct(product: Product): Product {
        val mapProduct = ProductRequest(product.name,product.productCategory,product.isImportant,product.count,product.maxCount) //todo правильно ли мапить из 1 потом обратно?
        val result = productApi.createProduct(mapProduct)
        return Product(result.name,result.productCategory,result.isImportant,result.count,result.maxCount)
    }
}