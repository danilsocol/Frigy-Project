package com.example.frigy_project.models

sealed class Product (
    override val id: Int,
    override val name: String,
    open val productCategory: ProductCategory) : IFilterable
{

    data class DefaultProduct(
        override val id: Int,
        override val name: String,
        override val productCategory: ProductCategory,
        val count: Int,
    ): Product(id,name,productCategory)

    data class ImportantProduct(
        override val id: Int,
        override val name: String,
        override val productCategory: ProductCategory,
        val count: Int,
        val maxCount: Int
    ) : Product(id,name,productCategory)

    data class ProductToBuy(
        override val id: Int,
        override val name: String,
        override val productCategory: ProductCategory,
        val countToBuy: Int,
        val isBuy : Boolean = false
    ) : Product(id,name,productCategory)

}


