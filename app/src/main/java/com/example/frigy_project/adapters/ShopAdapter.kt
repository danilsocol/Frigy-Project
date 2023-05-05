package com.example.frigy_project.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.example.frigy_project.databinding.ItemProductBinding
import com.example.frigy_project.databinding.ItemShopBinding
import com.example.frigy_project.filters.ProductFilter
import com.example.frigy_project.models.CategoryList
import com.example.frigy_project.models.Product

class ShopAdapter : BaseAdapter<Product>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductToBuyHolder {
        val binding = ItemShopBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ProductToBuyHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductToBuyHolder).bind(getItem(position))
    }

    override fun setData(newList: List<Product>) {
        originalList = newList
        submitList(originalList)
    }

    override fun getFilter(): Filter {
        return ProductFilter(originalList!!.toList(), this)
    }

    class ProductToBuyHolder(private val binding: ItemShopBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Product) = with(binding) {

            nameFood.text = food.name
            //countFood.text = (food.count.toString())
            iconFoodCategory.setImageResource(CategoryList.listFoodCategory[food.categoryProduct][2] as Int)
          /*  header.text = news.header
            subHeader.text = news.subhead
            subHeader2.text = news.subhead
            title.text = news.title
            image.setImageResource(news.iconId)
            avatar.setImageResource(news.userAvatarId)
            description.text = news.description


            itemView.setOnClickListener{
                listener.onClick(news)
            }*/

        }

    }


}
