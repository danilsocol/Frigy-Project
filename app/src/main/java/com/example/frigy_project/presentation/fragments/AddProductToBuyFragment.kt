package com.example.frigy_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductToBuyCreate
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.frigy_project.R
import com.example.frigy_project.databinding.FragmentAddProductToBuyBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddProductToBuyFragment : BottomSheetDialogFragment() {
    private var _binding:  FragmentAddProductToBuyBinding? = null
    private val binding get() = _binding!!
    private var mListener: CreateProductToBuyBottomSheetListener? = null

    val images = arrayOf(
        R.drawable.product_category_liquid_64,
        R.drawable.product_category_piece_64,
        R.drawable.product_category_weighing_64
    )



    var allProduct = arrayListOf<Product>(
        Product.DefaultProduct(0,"Молоко", ProductCategory(0,"Жидкость", "литр"),  1),
        Product.DefaultProduct( 1,"Beer", ProductCategory(0,"Жидкость", "литр"),  2),
        Product.DefaultProduct( 2,"Milk", ProductCategory(0,"Жидкость", "литр"),  3),
    )
    var selectedProduct : Product = allProduct[0]
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

        val adapter = context?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                allProduct.map { it.title })
        }
        binding.productSpinner.adapter = adapter

        binding.productSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.iconFoodCategory.setImageResource(images[allProduct[position].productCategory.id])
                binding.countFood.setText(allProduct[position].count.toString())
                selectedProduct = allProduct[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.iconFoodCategory.setImageResource(images[allProduct[0].productCategory.id])
                binding.countFood.setText(allProduct[0].count.toString())
                selectedProduct = allProduct[0]
            }
        }
     /*   binding.productSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedProduct = allProduct[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                selectedProduct = allProduct[0]
            }
        }*/

    }

    private fun clickSubmitBtn() // todo сделать проверку пустой ли
    {
        val product = ProductToBuyCreate(
                title = selectedProduct.title,
                productCategory = selectedProduct.productCategory,
                isImportant = selectedProduct is Product.ImportantProduct,
                count = binding.buyCount.toString().toIntOrNull() ?: 1,
                maxCount = null,
                isBuy = false
            )


        mListener?.clickOnSubmit(product)
        dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setListener(listener: CreateProductToBuyBottomSheetListener) {
        mListener = listener
    }

    interface CreateProductToBuyBottomSheetListener {
        fun clickOnSubmit(result: ProductToBuyCreate)
    }
}