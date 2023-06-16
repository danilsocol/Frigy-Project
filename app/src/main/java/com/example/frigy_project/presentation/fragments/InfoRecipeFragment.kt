package com.example.frigy_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.Recipe
import com.example.frigy_project.R
import com.example.frigy_project.app.App
import com.example.frigy_project.databinding.FragmentInfoRecipeBinding
import com.example.frigy_project.databinding.FragmentRecipeListBinding
import com.example.frigy_project.presentation.viewModels.RecipeFragmentViewModel

class InfoRecipeFragment : Fragment() {

    private var _binding:  FragmentInfoRecipeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoRecipeBinding.inflate(layoutInflater)

        init()
        //viewModel.init()
        return binding.root
    }

    private fun init(){

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}