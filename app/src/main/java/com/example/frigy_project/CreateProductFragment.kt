package com.example.frigy_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.frigy_project.databinding.FragmentCreateProductBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateProductFragment  : BottomSheetDialogFragment(){

    private var _binding:  FragmentCreateProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateProductBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    private fun init(){
        binding.closeBtn.setOnClickListener{dismiss()}
        binding.submitBtn.setOnClickListener { ClickSubmitBtn() }
        binding.checkboxImportantProduct.setOnClickListener { ClickCheckboxImportantProduct() }
    }


    private fun ClickSubmitBtn()
    {
        /*var product : ProductCreate = ProductCreate(
            name = binding.editName.text.toString(),
            productCategory = binding.categorySpinner.selectedItem.toString(),
            isImportant = binding.checkboxImportantProduct.isChecked,

        )*/
    }

    private fun ClickCheckboxImportantProduct(){
        if(binding.checkboxImportantProduct.isChecked)
            binding.maxCountLayout.visibility = View.VISIBLE
        else
            binding.maxCountLayout.visibility = View.INVISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}