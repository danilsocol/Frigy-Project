package com.example.frigy_project.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.Product
import com.example.frigy_project.R
import com.example.frigy_project.presentation.adapters.ShopAdapter
import com.example.frigy_project.databinding.FragmentShopListBinding
import com.example.frigy_project.presentation.viewModels.ShopFragmentViewModel

class ShopFragment : Fragment() {

    private var _binding:  FragmentShopListBinding? = null
    private val binding get() = _binding!!

    private val shopAdapter = ShopAdapter()
    private lateinit var viewModel : ShopFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShopListBinding.inflate(layoutInflater)

        init()
        viewModel.init()
        return binding.root
    }

    private fun init() {
        viewModel = ViewModelProvider(this)[ShopFragmentViewModel::class.java]

        val observer = Observer<List<Product>?> { list ->
            shopAdapter.setData(list)
        }
        viewModel.products.observe(viewLifecycleOwner, observer)

        val searchItem = binding.toolbar.menu.findItem(R.id.search)
        val addItem = binding.toolbar.menu.findItem(R.id.add)
        val searchBar = searchItem.actionView as SearchView

        searchBar.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                addItem.isVisible = newText.isNullOrEmpty()
                shopAdapter.filter.filter(newText)
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