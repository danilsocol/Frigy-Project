package com.example.frigy_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.frigy_project.databinding.FragmentRecipeListBinding

class ListRecipesFragment : Fragment() {

    private var binding: FragmentRecipeListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_list, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}