package com.example.frigy_project.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.frigy_project.R
import com.example.frigy_project.presentation.adapters.RecipeAdapter
import com.example.frigy_project.databinding.FragmentRecipeListBinding
import com.example.frigy_project.presentation.dtos.Recipe
import com.example.frigy_project.presentation.viewModels.RecipeFragmentViewModel

class RecipesFragment : Fragment() {

    private var _binding:  FragmentRecipeListBinding? = null
    private val binding get() = _binding!!

    private val recipeAdapter = RecipeAdapter()
    private lateinit var viewModel : RecipeFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeListBinding.inflate(layoutInflater)

        init()
        viewModel.init()
        return binding.root
    }

    private fun init(){
        viewModel = ViewModelProvider(this)[RecipeFragmentViewModel::class.java]

        val observer = Observer<List<Recipe>?> { list ->
            recipeAdapter.setData(list)
        }
        viewModel.recipes.observe(viewLifecycleOwner, observer)



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