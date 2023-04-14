package com.example.frigy_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.frigy_project.databinding.FragmentShopListBinding


class FridgeFragment : Fragment() {

    private var binding: FragmentShopListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fridge, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}