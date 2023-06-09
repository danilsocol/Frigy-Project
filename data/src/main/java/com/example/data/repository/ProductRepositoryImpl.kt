package com.example.data.repository

import com.example.data.models.ProductStorageRequestImpl
import com.example.data.models.ProductToBuyRequestImpl
import com.example.data.networks.ProductAPI
import com.example.data.retrofit.RetrofitBuilder
import com.example.domain.dto.ProductCreate
import com.example.domain.repository.ProductRepository


class ProductRepositoryImpl : ProductRepository { // todo выделить отдельный класс, а репозиторий оставить общим (а может и нет)

    private val retrofit = RetrofitBuilder.getClient()
    private val productApi = retrofit!!.create(ProductAPI::class.java)

    override suspend fun getStorageProductById(id: String): ProductStorageRequestImpl {
        val product = productApi.getProductById(id)
        return ProductStorageRequestImpl(product.title,product.productCategory,
            product.isImportant,product.countStorage,product.maxCountStorage)
    }

    override suspend fun getAllStorageProducts(): List<ProductStorageRequestImpl> {
        return productApi.getAllProducts().map { product -> ProductStorageRequestImpl(product.title,product.productCategory,
            product.isImportant,product.countStorage,product.maxCountStorage) }
    }

    override suspend fun createProduct(product: ProductCreate): ProductStorageRequestImpl {
        val mapProduct = ProductStorageRequestImpl(product.title,product.productCategory,product.isImportant,product.countStorage,product.maxCountStorage) //todo правильно ли мапить из 1 потом обратно?
        val result = productApi.createProduct(mapProduct)
        return ProductStorageRequestImpl(result.title,result.productCategory,result.isImportant,product.countStorage,product.maxCountStorage)
    }
}