package com.example.frigy_project.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.frigy_project.databinding.ItemProductBinding
import com.example.frigy_project.filters.FridgeFilter
import com.example.frigy_project.models.CategoryList.listFoodCategory
import com.example.frigy_project.models.Product

class FridgeAdapter() : ListAdapter<Product, FridgeAdapter.FoodHolder>(DiffCallback<Product>()), IFilterable<Product> {

    var originalList : List<Product>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {

        val binding = ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false)
        return FoodHolder(binding)

    }
    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun setData(newList: List<Product>) {
        originalList = newList
        submitList(originalList)
    }

    override fun getFilter(): Filter {
        return FridgeFilter(originalList!!.toList(), this)
    }

    class FoodHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Product) = with(binding) {

            nameFood.text = food.name
            countFood.text = (food.count.toString())
            iconFoodCategory.setImageResource(listFoodCategory[food.categoryProduct][2] as Int)
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


}
