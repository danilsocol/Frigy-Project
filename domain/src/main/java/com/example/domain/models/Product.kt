package com.example.domain.models

import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductRequest
import com.example.domain.dto.ProductToBuyCreate
import com.example.domain.dto.ProductToBuyRequest

sealed class Product(
    open val id: Int,
    override val title: String,
    open val productCategory: ProductCategory,
    open var count: Int
) : IFilterable {

    fun addCount() {
        count++
    }

    fun reduceCount() {
        count--
    }

    data class DefaultProduct(
        override val id: Int,
        override val title: String,
        override val productCategory: ProductCategory,
        override var count: Int,
    ) : Product(id, title, productCategory, count)

    data class ImportantProduct(
        override val id: Int,
        override val title: String,
        override val productCategory: ProductCategory,
        override var count: Int,
        var maxCount: Int
    ) : Product(id, title, productCategory, count) {
        fun addMaxCount() {
            maxCount++
        }

        fun reduceMaxCount() {
            maxCount--
        }
    }

    data class ProductToBuy(
        override val id: Int,
        override val title: String,
        override val productCategory: ProductCategory,
        override var count: Int,
        var isBuy: Boolean = false
    ) : Product(id, title, productCategory, count)

    data class ImportantProductToBuy(
        override val id: Int,
        override val title: String,
        override val productCategory: ProductCategory,
        override var count: Int,
        val maxCount: Int,
        var isBuy: Boolean = false
    ) : Product(id, title, productCategory, count)

    companion object Factory {
        val productCategoryList = listOf(
            (ProductCategory(0, "Жидкость", "литр")),
            (ProductCategory(1, "Взвешиваемый", "кг")),
            (ProductCategory(2, "Поштучный", "шт"))
        )
        var countProduct: Int = 0
        fun getProduct(res: ProductRequest): Product {
            checkCount(res.id)
            return if (res.maxCount == null) {
                DefaultProduct(
                    res.id,
                    res.title,
                    productCategoryList[res.productCategory],
                    res.count
                )
            } else {
                ImportantProduct(
                    res.id,
                    res.title,
                    productCategoryList[res.productCategory],
                    res.count,
                    res.maxCount!!
                )
            }
        }

        fun getProduct(res: ProductCreate): Product {
            val product: Product
            if (res.maxCount == null) {
                product = DefaultProduct(
                    countProduct,
                    res.title,
                    productCategoryList[res.productCategory],
                    res.count
                )
            } else {
                product = ImportantProduct(
                    countProduct,
                    res.title,
                    productCategoryList[res.productCategory],
                    res.count,
                    res.maxCount
                )
            }
            countProduct++
            return product
        }

        fun getProductToBuy(res: ProductToBuyRequest): Product {
            checkCount(res.id)
            return if (res.maxCount == null) {
                ProductToBuy(
                    res.id,
                    res.title,
                    productCategoryList[res.productCategory],
                    res.count,
                    res.isBuy
                )
            } else {
                ImportantProductToBuy(
                    res.id,
                    res.title,
                    productCategoryList[res.productCategory],
                    res.count,
                    res.maxCount!!,
                    res.isBuy
                )
            }
        }

        fun getProductToBuy(res: ProductToBuyCreate): Product {
            val product: Product
            if (res.maxCount == null) {
                product = ProductToBuy(
                    countProduct,
                    res.title,
                    productCategoryList[res.productCategory],
                    res.count,
                    res.isBuy
                )
            } else {
                product = ImportantProductToBuy(
                    countProduct,
                    res.title,
                    productCategoryList[res.productCategory],
                    res.count,
                    res.maxCount,
                    res.isBuy
                )
            }
            countProduct++
            return product
        }

        fun getNewId(): Int {
            val result = countProduct
            countProduct++
            return result
        }

        fun checkCount(id: Int) {
            if (id >= countProduct) {
                countProduct = id + 1
            }
        }

        fun getAllProductStorage(res: List<ProductRequest>): List<Product> {
            return res.map { getProduct(it) }
        }

        fun getAllProductToBuy(res: List<ProductToBuyRequest>): List<Product> {
            return res.map { getProductToBuy(it) }
        }
    }
}