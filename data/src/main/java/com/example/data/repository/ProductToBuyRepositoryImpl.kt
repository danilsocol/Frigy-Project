package com.example.data.repository

import com.example.data.models.ProductRequestImpl
import com.example.data.models.ProductToBuyRequestImpl
import com.example.data.models.ProductToBuyUpdateRequestImpl
import com.example.data.networks.ProductToBuyAPI
import com.example.domain.dto.ProductRequest
import com.example.domain.dto.ProductToBuyCreate
import com.example.domain.dto.ProductToBuyRequest
import com.example.domain.dto.ProductToBuyUpdate
import com.example.domain.dto.ProductToBuyUpdateRequest
import com.example.domain.models.Product
import com.example.domain.repository.ProductToBuyRepository
import javax.inject.Inject

class ProductToBuyRepositoryImpl@Inject constructor(private val productToBuyApi : ProductToBuyAPI)  : ProductToBuyRepository {
    override suspend fun getAllProductsToBuy(): List<Product> {
        return Product.getAllProductToBuy( productToBuyApi.getAllProducts())
    }

    override suspend fun deleteAllCheckProduct(list: List<Int>) {
        productToBuyApi.deleteCheckProducts(list)
    }

    override suspend fun createProduct(productToBuyCreate: ProductToBuyCreate) {
        val mapProduct = ProductToBuyRequestImpl(Product.getNewId(),productToBuyCreate.title,
            productToBuyCreate.productCategory,productToBuyCreate.isImportant,productToBuyCreate.count
            ,productToBuyCreate.maxCount, productToBuyCreate.isBuy)
        productToBuyApi.createProduct(mapProduct)
    }

    override suspend fun updateProduct(productToBuyUpdate: ProductToBuyUpdate) {
        val mapProduct = ProductToBuyUpdateRequestImpl(productToBuyUpdate.id,productToBuyUpdate.isBuy)
        productToBuyApi.updateProduct(mapProduct)
    }
}
