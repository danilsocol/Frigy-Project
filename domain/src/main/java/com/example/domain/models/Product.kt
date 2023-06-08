package com.example.domain.models

import com.example.domain.dto.ProductStorageRequest
import com.example.domain.dto.ProductToBuyRequest

sealed class Product (
    open val title: String,
    open val productCategory: ProductCategory){

    data class DefaultProduct(
        override val title: String,
        override val productCategory: ProductCategory,
        val countStorage: Int,
    ) : Product(title,productCategory)

    data class ImportantProduct(
        override val title: String,
        override val productCategory: ProductCategory,
        val countStorage: Int,
        val maxCountStorage: Int
    ) : Product(title, productCategory)

    data class ProductToBuy(
        override val title: String,
        override val productCategory: ProductCategory,
        val countToBuy: Int,
        val isBuy: Boolean = false
    ) : Product(title, productCategory)

    data class ImportantProductToBuy(
        override val title: String,
        override val productCategory: ProductCategory,
        val countToBuy: Int,
        val maxCountStorage: Int,
        val isBuy: Boolean = false
    ) : Product(title, productCategory)

    companion object Factory {
        private val productCategoryList  =  listOf(
            (ProductCategory(1,"Жидкость", "литр")),
            (ProductCategory(2,"Взвешиваемый","кг")),
            (ProductCategory(3,"Поштучный","шт"))
        )
        fun getProductStorage(res: ProductStorageRequest): Product{
            return if(res.maxCountStorage == null){
                DefaultProduct(res.title,productCategoryList[res.productCategory],res.countStorage)
            } else{
                ImportantProduct(res.title,productCategoryList[res.productCategory],res.countStorage,res.maxCountStorage!!)
            }
        }

        fun getProductToBuyStorage(res: ProductToBuyRequest): Product{
            return if(res.maxCountStorage == null){
                ProductToBuy(res.title,productCategoryList[res.productCategory],res.countToBuy,res.isBuy)
            } else{
                ImportantProductToBuy(res.title,productCategoryList[res.productCategory],res.countToBuy,res.maxCountStorage!!,res.isBuy)
            }
        }
        fun getAllProductStorage(responses: List<ProductStorageRequest>): List<Product>{
            return responses.map { getProductStorage(it) }
        }
        fun getAllProductToBuy(responses: List<ProductToBuyRequest>): List<Product>{
            return responses.map { getProductToBuyStorage(it) }
        }
    }
}