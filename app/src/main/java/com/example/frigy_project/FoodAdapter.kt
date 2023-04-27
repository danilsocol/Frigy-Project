package com.example.frigy_project

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.frigy_project.databinding.ItemFoodBinding
import com.example.frigy_project.models.CategoryList.listFoodCategory
import com.example.frigy_project.models.FoodModel

class FoodAdapter : ListAdapter<FoodModel, FoodAdapter.FoodHolder>(MyDiffCallback()), Filterable {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {

        val binding = ItemFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false)
        return FoodHolder(binding)

    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.bind(getItem(position))
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

    private var list = mutableListOf<FoodModel>()


    override fun getFilter(): Filter {
        return customFilter
    }

    private val customFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList = mutableListOf<FoodModel>()
            if (constraint.isNullOrEmpty()) {
                filteredList.addAll(list)
            } else {
                for (item in list) {
                    if (item.name.toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                        filteredList.add(item)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, filterResults: FilterResults?) {
            list.clear()
            list.addAll(filterResults?.values as MutableList<FoodModel>)
            submitList(list)
        }


    }

}
