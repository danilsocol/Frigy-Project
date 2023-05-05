package com.example.frigy_project.models

sealed class Product (
    open val id: Int,
    open val name: String,
    open val categoryProduct: Int)
{

    data class DefaultProduct(
        override val id: Int,
        override val name: String,
        override val categoryProduct: Int,
        val count: Double,
    ): Product(id,name,categoryProduct)

    data class ImportantProduct(
        override val id: Int,
        override val name: String,
        override val categoryProduct: Int,
        val count: Double,
        val maxCount: Double
    ) : Product(id,name,categoryProduct)

    data class ProductToBuy(
        override val id: Int,
        override val name: String,
        override val categoryProduct: Int,
        val countToBuy: Double,
        val isBuy : Boolean = false
    ) : Product(id,name,categoryProduct)

}


