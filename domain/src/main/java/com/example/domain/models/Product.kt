package com.example.domain.models

import com.example.domain.dto.ProductRequest
import com.example.domain.dto.ProductToBuyRequest

sealed class Product (
    override val title: String,
    open val productCategory: ProductCategory,
    open val count: Int
    ) : IFilterable {

    data class DefaultProduct(
        override val title: String,
        override val productCategory: ProductCategory,
        override val count: Int,
    ) : Product(title,productCategory,count)

    data class ImportantProduct(
        override val title: String,
        override val productCategory: ProductCategory,
        override val count: Int,
        val maxCount: Int
    ) : Product(title, productCategory,count)

    data class ProductToBuy(
        override val title: String,
        override val productCategory: ProductCategory,
        override val count: Int,
        var isBuy: Boolean = false
    ) : Product(title, productCategory,count)

    data class ImportantProductToBuy(
        override val title: String,
        override val productCategory: ProductCategory,
        override val count: Int,
        val maxCount: Int,
        var isBuy: Boolean = false
    ) : Product(title, productCategory,count)

    companion object Factory {
        val productCategoryList  =  listOf(
            (ProductCategory(0,"Жидкость", "литр")),
            (ProductCategory(1,"Взвешиваемый","кг")),
            (ProductCategory(2,"Поштучный","шт"))
        )
        fun getProduct(res: ProductRequest): Product{
            return if(res.maxCount == null){
                DefaultProduct(res.title,productCategoryList[res.productCategoryInt],res.count)
            } else{
                ImportantProduct(res.title,productCategoryList[res.productCategoryInt],res.count,res.maxCount!!)
            }
        }

        fun getProductToBuy(res: ProductToBuyRequest): Product{
            return if(res.maxCount == null){
                ProductToBuy(res.title,productCategoryList[res.productCategory],res.count,res.isBuy)
            } else{
                ImportantProductToBuy(res.title,productCategoryList[res.productCategory],res.count,res.maxCount!!,res.isBuy)
            }
        }
        fun getAllProductStorage(res: List<ProductRequest>): List<Product>{
            return res.map { getProduct(it) }
        }
        fun getAllProductToBuy(res: List<ProductToBuyRequest>): List<Product>{
            return res.map { getProductToBuy(it) }
        }
    }
}