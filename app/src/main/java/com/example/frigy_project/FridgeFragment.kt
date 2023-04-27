package com.example.frigy_project


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.frigy_project.databinding.FragmentFridgeBinding
import com.example.frigy_project.models.FoodModel


class FridgeFragment : Fragment() {

    private var _binding:  FragmentFridgeBinding? = null
    private val foodAdapter = FoodAdapter()

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        _binding = FragmentFridgeBinding.inflate(layoutInflater)

        init()
        return binding.root
    }


    private fun init() {
        val list = listOf<FoodModel>(
            FoodModel(1, "Молоко", 0, false, 1.0, 0.0),
            FoodModel(1, "Beer", 0, false, 1.0, 0.0),
            FoodModel(1, "Milk", 0, false, 1.0, 0.0),
        )
        foodAdapter.submitList(list)

        val searchItem = binding.toolbar.menu.findItem(R.id.search)
        val searchBar = searchItem.actionView as SearchView

        searchBar.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                foodAdapter.filter.filter(newText)
                return true
            }
        }
        )

        binding.apply {
            rcViewFridge.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            rcViewFridge.adapter = foodAdapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView() //todo удаление
        _binding = null
    }
}