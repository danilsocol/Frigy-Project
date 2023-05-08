package com.example.frigy_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.frigy_project.adapters.RecipeAdapter
import com.example.frigy_project.adapters.ShopAdapter
import com.example.frigy_project.databinding.FragmentRecipeListBinding
import com.example.frigy_project.databinding.FragmentShopListBinding
import com.example.frigy_project.models.Product
import com.example.frigy_project.models.Recipe

class RecipesFragment : Fragment() {

    private val recipeAdapter = RecipeAdapter()
    private var _binding:  FragmentRecipeListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeListBinding.inflate(layoutInflater)

        init()
        return binding.root
    }

    private fun init(){
        val list = listOf<Recipe>(
            Recipe(1, "Суп с молоком", 0,
                listOf(
                    Product.DefaultProduct(1, "Молоко", 0, 1.0),
                    Product.DefaultProduct(2, "Креветки", 0, 1.0),
                )
            ),

            Recipe(2, "Суп с пивом", 0,
                listOf(
                    Product.DefaultProduct(1, "Пиво", 0, 1.0),
                    Product.DefaultProduct(2, "Креветки", 0, 1.0),
                )
            ),
            Recipe(2, "test", 0,
                listOf(
                    Product.DefaultProduct(1, "Пиво", 0, 1.0),
                    Product.DefaultProduct(2, "Креветки", 0, 1.0),
                )
            ),
        )

        recipeAdapter.setData(list)


        val searchItem = binding.toolbar.menu.findItem(R.id.search)
        val addItem = binding.toolbar.menu.findItem(R.id.add)
        val searchBar = searchItem.actionView as SearchView

        searchBar.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                addItem.isVisible = newText.isNullOrEmpty()
                recipeAdapter.filter.filter(newText)
                return true
            }
        }
        )

        binding.apply {
            rcViewAllRecipe.layoutManager = GridLayoutManager(
                context,3,
                LinearLayoutManager.VERTICAL, false
            )
            rcViewAllRecipe.adapter = recipeAdapter
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}