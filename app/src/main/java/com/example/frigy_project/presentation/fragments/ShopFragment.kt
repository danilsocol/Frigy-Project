package com.example.frigy_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductToBuyCreate
import com.example.domain.models.Product
import com.example.frigy_project.R
import com.example.frigy_project.app.App
import com.example.frigy_project.presentation.adapters.ShopAdapter
import com.example.frigy_project.databinding.FragmentShopListBinding
import com.example.frigy_project.presentation.viewModels.ShopFragmentViewModel

class ShopFragment : Fragment(), AddProductToBuyFragment.CreateProductToBuyBottomSheetListener {

    private var _binding:  FragmentShopListBinding? = null
    private val binding get() = _binding!!

    private lateinit var shopAdapter : ShopAdapter //todo убрать viewModel беренести в dagger
    private lateinit var viewModel : ShopFragmentViewModel
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
        val component = (activity?.application as App).component
        viewModel = component.viewModelFactory().create(ShopFragmentViewModel::class.java)
        shopAdapter = ShopAdapter(viewModel)

        val observer = Observer<List<Product>?> { list ->
            shopAdapter.setData(list)
        }
        viewModel.products.observe(viewLifecycleOwner, observer)

        val searchItem = binding.toolbar.menu.findItem(R.id.search)
        val buyItem = binding.toolbar.menu.findItem(R.id.buy)
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
        })

        addItem.setOnMenuItemClickListener {
            val newBottomSheetFragment = AddProductToBuyFragment()
            newBottomSheetFragment.setListener(this)
            newBottomSheetFragment.show(requireActivity().supportFragmentManager, "AddProductToBuyFragment")
            return@setOnMenuItemClickListener true
        }

        buyItem.setOnMenuItemClickListener {
            viewModel.buyProduct()
            return@setOnMenuItemClickListener true
        }

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

    override fun clickOnSubmit(result: ProductToBuyCreate) {
        viewModel.createProduct(result)
    }
}