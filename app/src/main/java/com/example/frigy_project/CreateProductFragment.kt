package com.example.frigy_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.frigy_project.databinding.FragmentCreateProductBinding
import com.example.frigy_project.models.ProductCreate
import com.example.frigy_project.viewModels.FridgeFragmentViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateProductFragment  : BottomSheetDialogFragment(){

    private var _binding:  FragmentCreateProductBinding? = null
    private val binding get() = _binding!!
    private val viewModel : FridgeFragmentViewModel by activityViewModels()

    private var mListener: BottomSheetListener? = null
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
        binding.submitBtn.setOnClickListener { clickSubmitBtn() }
        binding.checkboxImportantProduct.setOnClickListener { ClickCheckboxImportantProduct() }
    }


    private fun clickSubmitBtn() // todo сделать проверку пустой ли
    {
        val product : ProductCreate = ProductCreate(
            name = binding.editName.text.toString(),
            productCategory = binding.categorySpinner.selectedItem.toString(),
            isImportant = binding.checkboxImportantProduct.isChecked,
            maxCount = binding.maxCount.text.toString().toIntOrNull()
        )
        mListener?.clickOnSubmit(product)
        dismiss()
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

    fun setListener(listener: BottomSheetListener) {
        mListener = listener
    }

    interface BottomSheetListener {
        fun clickOnSubmit(result: ProductCreate)
    }

}