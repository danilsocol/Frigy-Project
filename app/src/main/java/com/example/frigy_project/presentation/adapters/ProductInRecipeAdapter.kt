package com.example.frigy_project.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Product
import com.example.frigy_project.R
import com.example.frigy_project.databinding.ItemBinding
import com.example.frigy_project.databinding.ItemProductBinding
import com.example.frigy_project.presentation.utils.ProductCategoryList

class ProductInRecipeAdapter : ListAdapter<Product, RecyclerView.ViewHolder>(DiffCallback<Product>()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
       return ProductHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       (holder as ProductHolder).bind(getItem(position) as Product.DefaultProduct)
    }


    class ProductHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) = with(binding) {

            title.text = product.title
            count.text = product.count.toString()
        }
    }
}