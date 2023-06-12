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
import com.example.frigy_project.R
import com.example.frigy_project.presentation.adapters.FridgeAdapter
import com.example.frigy_project.databinding.FragmentFridgeBinding
import com.example.frigy_project.presentation.dtos.Product
import com.example.frigy_project.presentation.models.ProductCreate
import com.example.frigy_project.presentation.viewModels.FridgeFragmentViewModel


class FridgeFragment : Fragment(), CreateProductFragment.BottomSheetListener {

    private var _binding:  FragmentFridgeBinding? = null
    private val binding get() = _binding!!

    private val fridgeAdapter = FridgeAdapter()
    private lateinit var viewModel : FridgeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        _binding = FragmentFridgeBinding.inflate(layoutInflater)

        init()
        viewModel.init()
        return binding.root
    }

    private fun init() {
        viewModel = ViewModelProvider(this)[FridgeFragmentViewModel::class.java]

        val observer = Observer<List<Product>?> { list ->
            fridgeAdapter.setData(list)
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
                    fridgeAdapter.filter.filter(newText)
                    return true
                }
            }
        )

        addItem.setOnMenuItemClickListener {
            val newBottomSheetFragment = CreateProductFragment()
            newBottomSheetFragment.setListener(this)
            newBottomSheetFragment.show(requireActivity().supportFragmentManager, "CreateProductFragment")
            return@setOnMenuItemClickListener true
        }


        binding.apply {
            rcViewFridge.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            rcViewFridge.adapter = fridgeAdapter
        }
    }
    override fun clickOnSubmit(result: ProductCreate) {
        viewModel.createProduct(result)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}