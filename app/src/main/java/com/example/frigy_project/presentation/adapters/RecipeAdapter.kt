package com.example.frigy_project.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Recipe
import com.example.frigy_project.databinding.ItemRecipeBinding
import com.example.frigy_project.presentation.filters.TitleFilter
import com.example.frigy_project.presentation.utils.RecipeCategoryList

class RecipeAdapter(private val listener: OnRecipeClickListener) : BaseAdapter<Recipe>() {
    override fun setData(newList: List<Recipe>) {
        originalList = newList
        submitList(originalList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RecipeHolder).bind(getItem(position))
    }

    override fun getFilter(): Filter {
        var l = originalList?.toList()
        if (l == null) l = currentList
        return TitleFilter(l, this)
    }

    inner class RecipeHolder(private val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: Recipe) = with(binding) {
            nameRecipe.text = recipe.title
            iconFoodCategory.setImageResource(RecipeCategoryList.getRecipeImgCategory(recipe.recipeCategory))

            itemView.setOnClickListener {
                listener.onItemClick(recipe)
            }
        }
    }

    interface OnRecipeClickListener {
        fun onItemClick(recipe: Recipe)
    }
}

