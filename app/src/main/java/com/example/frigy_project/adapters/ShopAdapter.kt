package com.example.frigy_project.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.frigy_project.databinding.ItemProductBinding
import com.example.frigy_project.filters.FridgeFilter
import com.example.frigy_project.models.CategoryList
import com.example.frigy_project.models.Product

class ShopAdapter : ListAdapter<Product.ProductToBuy, ShopAdapter.FoodHolder>(DiffCallback<Product.ProductToBuy>()),
    IFilterable<Product.ProductToBuy> {

    var originalList : List<Product.ProductToBuy>? = null

    class FoodHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Product) = with(binding) {

            nameFood.text = food.name
            countFood.text = (food.count.toString())
            iconFoodCategory.setImageResource(CategoryList.listFoodCategory[food.categoryProduct][2] as Int)
            /* header.text = news.header
             subHeader.text = news.subhead
             subHeader2.text = news.subhead
             title.text = news.title
             image.setImageResource(news.iconId)
             avatar.setImageResource(news.userAvatarId)
             description.text = news.description*/

            /* itemView.setOnClickListener{
                 listener.onClick(news)
             }*/
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return FoodHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun setData(newList: List<Product.ProductToBuy>) {
        originalList = newList
        submitList(originalList)
    }

    override fun getFilter(): Filter {
        return FridgeFilter(originalList!!.toList(), this)
    }



}