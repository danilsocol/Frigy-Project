package com.example.frigy_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.frigy_project.adapters.FridgeAdapter
import com.example.frigy_project.databinding.FragmentCreateProductBinding
import com.example.frigy_project.databinding.FragmentFridgeBinding

class CreateProductFragment  : Fragment(){

    private var _binding:  FragmentCreateProductBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateProductBinding.inflate(layoutInflater)

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView() //todo удаление
        _binding = null
    }
}