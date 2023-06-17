package com.example.frigy_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.Recipe
import com.example.frigy_project.R
import com.example.frigy_project.app.App
import com.example.frigy_project.databinding.FragmentInfoRecipeBinding
import com.example.frigy_project.databinding.FragmentRecipeListBinding
import com.example.frigy_project.presentation.adapters.ProductInRecipeAdapter
import com.example.frigy_project.presentation.utils.RecipeCategoryList
import com.example.frigy_project.presentation.viewModels.InfoRecipeFragmentViewModel
import com.example.frigy_project.presentation.viewModels.RecipeFragmentViewModel
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class InfoRecipeFragment : Fragment() {

    private var _binding:  FragmentInfoRecipeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : InfoRecipeFragmentViewModel

    private val productInRecipeAdapter = ProductInRecipeAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoRecipeBinding.inflate(layoutInflater)

        init()
        return binding.root
    }

    private fun init(){
        val component = (activity?.application as App).component
        viewModel = component.viewModelFactory().create(InfoRecipeFragmentViewModel::class.java)

        val id : Int? = arguments?.getInt("id")
        viewModel.init(id!!)

        val observer = Observer<Recipe> { recipe ->
            binding.nameRecipe.text = recipe.title
            binding.iconRecipeCategory.setImageResource(RecipeCategoryList.getRecipeImgCategory(recipe.recipeCategory))
            binding.description.text = recipe.description
            productInRecipeAdapter.submitList(recipe.productList)
        }
        viewModel.recipe.observe(viewLifecycleOwner, observer)

        binding.rcViewProduct.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        binding.rcViewProduct.adapter = productInRecipeAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed() // Обрабатываем клик на кнопке "назад"
        }
    }
    override fun onResume() {
        super.onResume()
        val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNav?.visibility = View.GONE
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}