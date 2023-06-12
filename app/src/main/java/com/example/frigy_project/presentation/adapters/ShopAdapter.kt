package com.example.frigy_project.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.example.frigy_project.R
import com.example.frigy_project.databinding.ItemImportantShopBinding
import com.example.frigy_project.databinding.ItemShopBinding
import com.example.frigy_project.presentation.filters.TitleFilter
import com.example.frigy_project.presentation.dtos.Product

class ShopAdapter : BaseAdapter<Product>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            R.layout.item_shop -> {
                val binding = ItemShopBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false)
                ProductToBuyHolder(binding)
            }

            R.layout.item_important_shop -> {
                val binding = ItemImportantShopBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false)
                ImportantProductToBuyHolder(binding)
            }
            else -> throw IllegalStateException("Неизвестный тип $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Product.ProductToBuy -> R.layout.item_shop
            is Product.ImportantProductToBuy -> R.layout.item_important_shop
            else -> Int.MAX_VALUE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            R.layout.item_shop -> (holder as ProductToBuyHolder).bind(
                getItem(position) as Product.ProductToBuy
            )

            R.layout.item_important_shop -> (holder as ImportantProductToBuyHolder).bind(
                getItem(position) as Product.ImportantProductToBuy
            )

            else -> throw IllegalStateException("Неизвестный тип ${holder.itemViewType}")
        }
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
            if(food.isBuy)
                checkBuy.setImageResource(R.drawable.check_64)
        }
    }

    class ImportantProductToBuyHolder(private val binding: ItemImportantShopBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Product.ImportantProductToBuy) = with(binding) {
            nameFood.text = food.name
            countFood.text = food.countToBuy.toString()
            iconFoodCategory.setImageResource(food.productCategory.iconCategory)
            unit.text = food.productCategory.unit
            if(food.isBuy)
                checkBuy.setImageResource(R.drawable.check_64)

            maxCount.text = food.maxCount.toString()
            unit.text = food.productCategory.unit
        }
    }

}
