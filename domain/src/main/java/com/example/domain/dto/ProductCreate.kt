package com.example.domain.dto

data class ProductCreate(
    override val title: String,
    override val productCategory: Int,
    override val isImportant : Boolean,
    override val count: Int,
    override val maxCount: Int?,
) : ProductRequest