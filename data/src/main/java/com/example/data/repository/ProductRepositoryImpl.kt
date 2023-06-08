package com.example.data.repository

import com.example.data.models.ProductStorageRequestImpl
import com.example.data.models.ProductToBuyRequestImpl
import com.example.data.networks.ProductAPI
import com.example.data.retrofit.RetrofitBuilder
import com.example.domain.repository.ProductRepository


class ProductRepositoryImpl : ProductRepository { // todo выделить отдельный класс, а репозиторий оставить общим (а может и нет)

    private val retrofit = RetrofitBuilder.getClient()
    private val productApi = retrofit!!.create(ProductAPI::class.java)

    override suspend fun getStorageProductById(id: String): ProductStorageRequestImpl {
        val product = productApi.getProductById(id)
        return Product(product.title,product.productCategory,product.isImportant,product.count,product.maxCount)
    }

    override suspend fun getProductToBuyById(id: String): ProductToBuyRequestImpl {
        val product = productApi.getProductById(id)
        return Product(product.title,product.productCategory,product.isImportant,product.count,product.maxCount)
    }

    override suspend fun getAllProducts(): List<Product> {
        return productApi.getAllProducts().map { product -> Product(product.title,product.productCategory,product.isImportant,product.count,product.maxCount) }
    }

    override suspend fun createProduct(product: Product): Product {
        val mapProduct = ProductStorageRequestImpl(product.title,product.productCategory,product.isImportant,product.count,product.maxCount) //todo правильно ли мапить из 1 потом обратно?
        val result = productApi.createProduct(mapProduct)
        return Product(result.title,result.productCategory,result.isImportant,result.count,result.maxCount)
    }
}