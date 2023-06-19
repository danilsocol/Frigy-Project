package com.example.frigy_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.AdapterView
import com.example.domain.dto.ProductCreate
import com.example.frigy_project.R
import com.example.frigy_project.databinding.FragmentCreateProductBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateProductFragment  : BottomSheetDialogFragment(){

    private var _binding:  FragmentCreateProductBinding? = null
    private val binding get() = _binding!!
    private var mListener: CreateProductBottomSheetListener? = null

    val images = arrayOf(
        R.drawable.product_category_liquid_64,
        R.drawable.product_category_weighing_64,
        R.drawable.product_category_piece_64
    )

    var categoryMap = mapOf<String,Int>(
        "Жидкость" to 0,
        "Взвешиваемый" to 1,
        "Поштучный" to  2)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateProductBinding.inflate(layoutInflater)
        dialog!!.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN
                or WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)

        init()
        return binding.root
    }

    private fun init(){

        binding.closeBtn.setOnClickListener{dismiss()}
        binding.submitBtn.setOnClickListener { clickSubmitBtn() }
        binding.checkboxImportantProduct.setOnClickListener { ClickCheckboxImportantProduct() }

        binding.categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.iconFoodCategory.setImageResource(images[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.iconFoodCategory.setImageResource(images[0])
            }
        }
    }

    private fun clickSubmitBtn() // todo сделать проверку пустой ли
    {
        val category = categoryMap[binding.categorySpinner.selectedItem.toString()]

        val product : ProductCreate = ProductCreate(
            title = binding.title.text.toString(),
            productCategory = category!!,
            isImportant = binding.checkboxImportantProduct.isChecked,
            count = 0,
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

    fun setListener(listener: CreateProductBottomSheetListener) {
        mListener = listener
    }

    interface CreateProductBottomSheetListener {
        fun clickOnSubmit(result: ProductCreate)
    }

}