package com.example.frigy_project.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Product
import com.example.frigy_project.R
import com.example.frigy_project.databinding.ItemImportantShopBinding
import com.example.frigy_project.databinding.ItemShopBinding
import com.example.frigy_project.presentation.filters.TitleFilter
import com.example.frigy_project.presentation.utils.ProductCategoryList
import com.example.frigy_project.presentation.viewModels.ShopFragmentViewModel
import javax.inject.Inject
import android.widget.Filter

class ShopAdapter @Inject constructor(private val shopFragmentViewModel: ShopFragmentViewModel) :
    BaseAdapter<Product>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            R.layout.item_shop -> {
                val binding = ItemShopBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                val holder = ProductToBuyHolder(binding)
                binding.root.setOnClickListener {
                    val position = holder.adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val product = (currentList[position] as Product.ProductToBuy)
                        product.isBuy = !product.isBuy
                        // (currentList[position] as Product.ProductToBuy).isBuy = !product.isBuy
                        shopFragmentViewModel.updateSelectedItem(position, currentList[position])
                    }
                }
                holder
            }

            R.layout.item_important_shop -> {
                val binding = ItemImportantShopBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                val holder = ImportantProductToBuyHolder(binding)
                binding.root.setOnClickListener {
                    val position = holder.adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val product = (currentList[position] as Product.ImportantProductToBuy)
                        product.isBuy = !product.isBuy
                        //   (currentList[position] as Product.ImportantProductToBuy).isBuy = !product.isBuy
                        shopFragmentViewModel.updateSelectedItem(position, product)
                    }
                }
                holder
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
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        var l = originalList?.toList()
        if (l == null) l = currentList
        return TitleFilter(l, this)
    }

    class ProductToBuyHolder(private val binding: ItemShopBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product.ProductToBuy) = with(binding) {

            nameFood.text = product.title
            countFood.text = product.count.toString()
            iconFoodCategory.setImageResource(ProductCategoryList.getProductImgCategory(product.productCategory))
            unit.text = product.productCategory.unit
            if (product.isBuy)
                checkBuy.setImageResource(R.drawable.check_64)
            else
                checkBuy.setImageResource(0)
        }
    }

    class ImportantProductToBuyHolder(private val binding: ItemImportantShopBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product.ImportantProductToBuy) = with(binding) {
            nameFood.text = product.title
            countFood.text = product.count.toString()
            iconFoodCategory.setImageResource(ProductCategoryList.getProductImgCategory(product.productCategory))
            unit.text = product.productCategory.unit
            if (product.isBuy)
                checkBuy.setImageResource(R.drawable.check_64)
            else
                checkBuy.setImageResource(0)
            maxCount.text = product.maxCount.toString()
            unit.text = product.productCategory.unit
        }
    }

}
