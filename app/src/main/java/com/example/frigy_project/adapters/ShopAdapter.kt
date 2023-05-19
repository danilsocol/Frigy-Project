package com.example.frigy_project.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.example.frigy_project.databinding.ItemShopBinding
import com.example.frigy_project.filters.TitleFilter
import com.example.frigy_project.dtos.Product

class ShopAdapter : BaseAdapter<Product>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductToBuyHolder {
        val binding = ItemShopBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ProductToBuyHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductToBuyHolder).bind(getItem(position) as Product.ProductToBuy)
    }

    override fun setData(newList: List<Product>) {
        originalList = newList
        submitList(originalList)
    }

    override fun getFilter(): Filter {
        return TitleFilter(originalList!!.toList(), this)
    }

    class ProductToBuyHolder(private val binding: ItemShopBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Product.ProductToBuy) = with(binding) {

            nameFood.text = food.name
            countFood.text = food.countToBuy.toString()
            iconFoodCategory.setImageResource(food.productCategory.iconCategory)
            unit.text = food.productCategory.unit

        }

    }



}
