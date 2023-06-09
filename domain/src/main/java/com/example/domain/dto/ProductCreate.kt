package com.example.domain.dto

data class ProductCreate(
    val title: String,
    val productCategory: Int,
    val isImportant : Boolean,
    val countStorage: Int,
    val maxCountStorage: Int?,
)