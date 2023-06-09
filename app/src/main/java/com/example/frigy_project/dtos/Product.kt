package com.example.frigy_project.dtos

import com.example.frigy_project.R
import com.example.frigy_project.models.ListСategories.ProductCategoryList.productCategoryList
import com.example.frigy_project.models.ProductCreate

sealed class Product (
    override val name: String,
    open val productCategory: ProductCategory) : IFilterable
{

    data class DefaultProduct(
        override val name: String,
        override val productCategory: ProductCategory,
        val count: Int,
    ): Product(name,productCategory)

    data class ImportantProduct(
        override val name: String,
        override val productCategory: ProductCategory,
        val count: Int,
        val maxCount: Int
    ) : Product(name,productCategory)

    data class ProductToBuy(
        override val name: String,
        override val productCategory: ProductCategory,
        val countToBuy: Int,
        val isBuy : Boolean = false
    ) : Product(name,productCategory)

    data class ImportantProductToBuy(
        override val name: String,
        override val productCategory: ProductCategory,
        val countToBuy: Int,
        val maxCount: Int,
        val isBuy : Boolean = false
    ) : Product(name,productCategory)

    companion object Factory {
        fun createProduct(data: ProductCreate): Product {
            val category : ProductCategory = when(data.productCategory){ //todo переделать под enum?
                "Жидкость" -> productCategoryList[0]
                "Взвешиваемый" -> productCategoryList[1]
                "Поштучный" -> productCategoryList[2]
                else -> throw Exception()
            }

            return if (!data.isImportant) {
                DefaultProduct(data.name,category,0)
            } else {
                ImportantProduct(data.name,category,0,data.maxCount!!)
            }
        }
    }
}


