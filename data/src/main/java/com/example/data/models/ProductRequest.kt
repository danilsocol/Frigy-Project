package com.example.data.models

data class ProductRequest (val name: String,
                           val productCategory: Int,
                           val isImportant : Boolean,
                           val count: Int,
                           val maxCount: Int?)