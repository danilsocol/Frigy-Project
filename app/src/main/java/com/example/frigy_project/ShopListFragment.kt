package com.example.frigy_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.frigy_project.adapters.ShopAdapter
import com.example.frigy_project.databinding.FragmentShopListBinding
import com.example.frigy_project.models.Product

class ShopListFragment : Fragment() {

    private var _binding:  FragmentShopListBinding? = null
    private val shopAdapter = ShopAdapter()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShopListBinding.inflate(layoutInflater)

        init()
        return binding.root
    }

    private fun init() {
        val list = listOf<Product>(
            Product.ProductToBuy(1, "Молоко", 0, 1.0),
            Product.ProductToBuy(1, "Beer", 0, 1.0),
            Product.ProductToBuy(1, "Milk", 0, 1.0),
        )

        shopAdapter.setData(list)

        val searchItem = binding.toolbar.menu.findItem(R.id.search)
        val searchBar = searchItem.actionView as SearchView

        searchBar.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    shopAdapter.filter.filter(null)
                } else {
                    shopAdapter.filter.filter(newText)
                }
                return true
            }
        }
        )

        binding.apply {
            rcViewFoodToBuy.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            rcViewFoodToBuy.adapter = shopAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}