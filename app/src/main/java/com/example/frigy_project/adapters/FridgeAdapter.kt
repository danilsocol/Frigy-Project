package com.example.frigy_project.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.example.frigy_project.R
import com.example.frigy_project.databinding.ItemImportantProductBinding
import com.example.frigy_project.databinding.ItemProductBinding
import com.example.frigy_project.filters.ProductFilter
import com.example.frigy_project.models.CategoryList.listFoodCategory
import com.example.frigy_project.models.Product

class FridgeAdapter() : BaseAdapter<Product>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            R.layout.item_product -> {
                val binding = ItemProductBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                ProductHolder(binding)
            }

            R.layout.item_important_product -> {
                val binding = ItemImportantProductBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                ImportantProductHolder(binding)
            }
            else -> throw IllegalStateException("Неизвестный тип $viewType")
        }
    }

        override fun getItemViewType(position: Int): Int {
            return when (getItem(position)) {
                is Product.DefaultProduct -> R.layout.item_product
                is Product.ImportantProduct -> R.layout.item_important_product
                else -> Int.MAX_VALUE
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder.itemViewType) {
                R.layout.item_product -> (holder as ProductHolder).bind(
                    getItem(position) as Product.DefaultProduct
                )

                R.layout.item_important_product -> (holder as ImportantProductHolder).bind(
                    getItem(position) as Product.ImportantProduct
                )

                else -> throw IllegalStateException("Неизвестный тип ${holder.itemViewType}")
            }
        }

        override fun setData(newList: List<Product>) {
            originalList = newList
            submitList(originalList)
        }

        override fun getFilter(): Filter {
            return ProductFilter(originalList!!.toList(), this)
        }

    class ProductHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Product) = with(binding) {

            nameFood.text = food.name
            //   countFood.text = (food.count.toString())
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

    class ImportantProductHolder(private val binding: ItemImportantProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Product) = with(binding) {

            nameFood.text = food.name
            //   countFood.text = (food.count.toString())
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
