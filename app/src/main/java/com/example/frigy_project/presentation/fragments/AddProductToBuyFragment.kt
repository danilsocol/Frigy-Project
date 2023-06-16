package com.example.frigy_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.example.domain.dto.ProductCreate
import com.example.frigy_project.R
import com.example.frigy_project.databinding.FragmentAddProductToBuyBinding
import com.example.frigy_project.databinding.FragmentCreateProductBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddProductToBuyFragment : BottomSheetDialogFragment() {
    private var _binding:  FragmentAddProductToBuyBinding? = null
    private val binding get() = _binding!!
    private var mListener: CreateProductToBuyBottomSheetListener? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddProductToBuyBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    private fun init(){

        binding.closeBtn.setOnClickListener{dismiss()}
        binding.submitBtn.setOnClickListener { clickSubmitBtn() }
       /* binding.checkboxImportantProduct.setOnClickListener { ClickCheckboxImportantProduct() }

        binding.categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.iconFoodCategory.setImageResource(images[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.iconFoodCategory.setImageResource(images[0])
            }
        }*/
    }

    private fun clickSubmitBtn() // todo сделать проверку пустой ли
    {
/*
        mListener?.clickOnSubmit()
        dismiss()*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setListener(listener: CreateProductToBuyBottomSheetListener) {
        mListener = listener
    }

    interface CreateProductToBuyBottomSheetListener {
        fun clickOnSubmit(result: ProductCreate)
    }
}