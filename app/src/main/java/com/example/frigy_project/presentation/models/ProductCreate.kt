package com.example.frigy_project.presentation.models


data class ProductCreate(
    val name: String,
    val productCategory: String,
    val isImportant: Boolean,
    val maxCount: Int?
)
