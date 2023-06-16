package com.example.frigy_project.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.domain.dto.ProductCreate
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.models.Recipe
import com.example.frigy_project.R
import com.example.frigy_project.databinding.FragmentCreateProductBinding
import com.example.frigy_project.databinding.FragmentCreateRecipeBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateRecipeFragment : BottomSheetDialogFragment() {
    private var _binding:  FragmentCreateRecipeBinding? = null
    private val binding get() = _binding!!
    private var mListener: CreateRecipeBottomSheetListener? = null

    val images = arrayOf(
        R.drawable.recipe_category_main_course_64,
        R.drawable.recipe_category_soup_64,
        R.drawable.recipe_category_salad_64
    )

    var categoryMap = mapOf<String,Int>(
        "Главное блюдо" to 0,
        "Суп" to 1,
        "Салат" to  2)

    val selectedProducts = ArrayList<Product>() // todo вынести список во viewModel
    var allProduct = arrayListOf<Product>(
        Product.DefaultProduct("Молоко", ProductCategory(1,"Жидкость", "литр"),  1),
        Product.DefaultProduct( "Beer", ProductCategory(1,"Жидкость", "литр"),  2),
        Product.DefaultProduct( "Milk", ProductCategory(1,"Жидкость", "литр"),  3),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateRecipeBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    private fun init(){

        val adapter = context?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                allProduct.map { it.title })
        }
        binding.productSpinner.adapter = adapter

        binding.closeBtn.setOnClickListener{dismiss()}
        binding.submitBtn.setOnClickListener { clickSubmitBtn() }
        binding.categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
             override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                 binding.iconRecipeCategory.setImageResource(images[position])
             }

             override fun onNothingSelected(parent: AdapterView<*>?) {
                 binding.iconRecipeCategory.setImageResource(images[0])
             }
         }

    }



    private fun clickAddProductBtn()
    {
        val product = binding.productSpinner.selectedItem as Product
        selectedProducts.add(product)
        Log.w("test",selectedProducts.toString())
    }

    private fun clickSubmitBtn() // todo сделать проверку пустой ли
    {
        /*val category = categoryMap[binding.categorySpinner.selectedItem.toString()]
        val productList =


        val recipe : Recipe = Recipe(
            title = binding.editName.text.toString(),
            description = "Описания пока что нет",
            recipeCategory = ,
            productList =
        )


        mListener?.clickOnSubmit()
        dismiss()*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setListener(listener: CreateRecipeBottomSheetListener) {
        mListener = listener
    }

    interface CreateRecipeBottomSheetListener {
        fun clickOnSubmit(result: ProductCreate)
    }
}