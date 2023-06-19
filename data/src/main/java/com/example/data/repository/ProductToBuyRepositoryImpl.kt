package com.example.data.repository

import com.example.data.models.ProductToBuyRequestImpl
import com.example.data.models.ProductToBuyUpdateRequestImpl
import com.example.data.networks.ProductToBuyAPI
import com.example.domain.dto.ProductToBuyCreate
import com.example.domain.dto.ProductToBuyUpdate
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.repository.ProductToBuyRepository
import javax.inject.Inject

class ProductToBuyRepositoryImpl @Inject constructor(private val productToBuyApi: ProductToBuyAPI) :
    ProductToBuyRepository {
    override suspend fun getAllProductsToBuy(): List<Product> {
        return try {
            Product.getAllProductToBuy(productToBuyApi.getAllProducts())
        } catch (e: Exception) {
            val mock = listOf<Product>(
                Product.ProductToBuy(0, "Молоко", ProductCategory(0, "Жидкость", "литр"), 1, true),
                Product.ProductToBuy(1, "Beer", ProductCategory(0, "Жидкость", "литр"), 2),
                Product.ProductToBuy(2, "Milk", ProductCategory(0, "Жидкость", "литр"), 4)
            )
            Product.Factory.countProduct = mock.size
            mock
        }
    }

    override suspend fun deleteAllCheckProduct(list: List<Int>) = try {
        productToBuyApi.deleteCheckProducts(list)
    } catch (_: Exception) { }

    override suspend fun createProduct(productToBuyCreate: ProductToBuyCreate) {
        try {
            val mapProduct = ProductToBuyRequestImpl(
                Product.getNewId(),
                productToBuyCreate.title,
                productToBuyCreate.productCategory,
                productToBuyCreate.isImportant,
                productToBuyCreate.count,
                productToBuyCreate.maxCount,
                productToBuyCreate.isBuy
            )
            productToBuyApi.createProduct(mapProduct)
        } catch (_: Exception) {

        }
    }

    override suspend fun updateProduct(productToBuyUpdate: ProductToBuyUpdate) {
        try {
            val mapProduct =
                ProductToBuyUpdateRequestImpl(productToBuyUpdate.id, productToBuyUpdate.isBuy)
            productToBuyApi.updateProduct(mapProduct)
        } catch (_: Exception) {

        }
    }
}
