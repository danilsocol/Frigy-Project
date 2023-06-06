package com.example.domain.models

data class Product (val name: String,
                    val productCategory: Int,
                    val isImportant : Boolean,
                    val count: Int,
                    val maxCount: Int?)