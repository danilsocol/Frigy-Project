package com.example.frigy_project.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.frigy_project.databinding.ItemFoodBinding
import com.example.frigy_project.filters.FridgeFilter
import com.example.frigy_project.models.CategoryList.listFoodCategory
import com.example.frigy_project.models.FoodModel

class FoodAdapter() : ListAdapter<FoodModel, FoodAdapter.FoodHolder>(MyDiffCallback()), Filterable {

    var originalList : List<FoodModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {

        val binding = ItemFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false)
        return FoodHolder(binding)

    }
    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setData(newList: List<FoodModel>) {
        originalList = newList
        submitList(originalList)
    }

    override fun getFilter(): Filter {
        return FridgeFilter(originalList!!.toList(), this)
    }

    class FoodHolder(private val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: FoodModel) = with(binding) {

            nameFood.text = food.name
            countFood.text = (food.count.toString())
            iconFoodCategory.setImageResource(listFoodCategory[food.categoryFood][2] as Int)
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


    class MyDiffCallback : DiffUtil.ItemCallback<FoodModel>() {

        override fun areItemsTheSame(oldItem: FoodModel, newItem: FoodModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: FoodModel, newItem: FoodModel): Boolean {
            return oldItem == newItem
        }
    }


}
