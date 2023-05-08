package com.example.frigy_project


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.frigy_project.adapters.FridgeAdapter
import com.example.frigy_project.databinding.FragmentFridgeBinding
import com.example.frigy_project.models.Product


class FridgeFragment : Fragment() {

    private var _binding:  FragmentFridgeBinding? = null
    private val binding get() = _binding!!

    private val fridgeAdapter = FridgeAdapter()

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
        val list = listOf<Product>(
            Product.DefaultProduct(1, "Молоко", 0,  1.0),
            Product.DefaultProduct(1, "Beer", 0,  1.0),
            Product.DefaultProduct(1, "Milk", 0,  1.0),
        )

        fridgeAdapter.setData(list) // todo подумать над изменением setData на subbmitlist

        val searchItem = binding.toolbar.menu.findItem(R.id.search)
        val searchBar = searchItem.actionView as SearchView

        searchBar.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) { //todo проверка на null
                    fridgeAdapter.filter.filter(null)
                } else {
                    fridgeAdapter.filter.filter(newText)
                }
                return true
            }
        }
        )

        binding.apply {
            rcViewFridge.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            rcViewFridge.adapter = fridgeAdapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView() //todo удаление
        _binding = null
    }
}