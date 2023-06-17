package com.example.frigy_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.dto.RecipeCreate
import com.example.domain.models.Recipe
import com.example.frigy_project.R
import com.example.frigy_project.app.App
import com.example.frigy_project.presentation.adapters.RecipeAdapter
import com.example.frigy_project.databinding.FragmentRecipeListBinding
import com.example.frigy_project.presentation.viewModels.RecipeFragmentViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog

class RecipesFragment : Fragment(), CreateRecipeFragment.CreateRecipeBottomSheetListener, RecipeAdapter.OnRecipeClickListener {

    private var _binding:  FragmentRecipeListBinding? = null
    private val binding get() = _binding!!

    private val recipeAdapter = RecipeAdapter(this)
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
        val component = (activity?.application as App).component
        viewModel = component.viewModelFactory().create(RecipeFragmentViewModel::class.java)

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

        addItem.setOnMenuItemClickListener {

          /*  val bottomSheetDialog = BottomSheetDialog(requireContext())
            val bottomSheetView = bottomSheetDialog.layoutInflater.inflate(R.layout.fragment_create_recipe, null)
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
            bottomSheetDialog.show()*/

            val newBottomSheetFragment = CreateRecipeFragment()
            newBottomSheetFragment.setListener(this)
            newBottomSheetFragment.show(requireActivity().supportFragmentManager, "CreateRecipeFragment")
            return@setOnMenuItemClickListener true
        }


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

    override fun clickOnSubmit(result: RecipeCreate) {
       viewModel.createRecipe(result)
    }

    override fun onItemClick(recipe: Recipe) {
        val bundle = Bundle()
        bundle.apply {
            putInt("id",recipe.id)
        }

        findNavController().navigate(R.id.toRecipe,bundle)
    }

    override fun onResume() {
        super.onResume()
        val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNav?.visibility = View.VISIBLE
    }
}