package com.example.frigy_project.presentation.fragments

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductRequest
import com.example.domain.dto.RecipeCreate
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.models.Recipe
import com.example.frigy_project.R
import com.example.frigy_project.app.App
import com.example.frigy_project.databinding.FragmentCreateRecipeBinding
import com.example.frigy_project.presentation.adapters.ProductInRecipeAdapter
import com.example.frigy_project.presentation.viewModels.FridgeFragmentViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateRecipeFragment : BottomSheetDialogFragment() {
    private var _binding:  FragmentCreateRecipeBinding? = null
    private val binding get() = _binding!!
    private var mListener: CreateRecipeBottomSheetListener? = null
    private val productInRecipeAdapter = ProductInRecipeAdapter()
    val images = arrayOf(
        R.drawable.recipe_category_main_course_64,
        R.drawable.recipe_category_soup_64,
        R.drawable.recipe_category_salad_64
    )

    var categoryMap = mapOf<String,Int>(
        "Главное блюдо" to 0,
        "Суп" to 1,
        "Салат" to  2)

    val productsInRecipe = ArrayList<Product>()
    var allProduct = arrayListOf<Product>(
        Product.DefaultProduct(0,"Молоко", ProductCategory(1,"Жидкость", "литр"),  1),
        Product.DefaultProduct( 1,"Beer", ProductCategory(1,"Жидкость", "литр"),  2),
        Product.DefaultProduct( 2,"Milk", ProductCategory(1,"Жидкость", "литр"),  3),
    )
    var selectedProduct : Product = allProduct[0]

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateRecipeBinding.inflate(layoutInflater)
        dialog!!.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN
                or WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)

        init()
        return binding.root
    }
    private fun init(){

        val component = (activity?.application as App).component
        val viewModel = component.viewModelFactory().create(FridgeFragmentViewModel::class.java)
        allProduct = viewModel.products.value as ArrayList<Product>

        val adapter = context?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                allProduct.map { it.title })
        }
        binding.productSpinner.adapter = adapter

        val adapterCategory = context?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                categoryMap.map { it.key })
        }
        binding.categorySpinner.adapter = adapterCategory

        binding.rcViewProduct.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        binding.rcViewProduct.adapter = productInRecipeAdapter


        binding.closeBtn.setOnClickListener{dismiss()}
        binding.submitBtn.setOnClickListener { clickSubmitBtn() }
        binding.addProduct.setOnClickListener {clickAddProductBtn() }
        binding.categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
             override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                 binding.iconRecipeCategory.setImageResource(images[position])
             }

             override fun onNothingSelected(parent: AdapterView<*>?) {
                 binding.iconRecipeCategory.setImageResource(images[0])
             }
         }
        binding.productSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedProduct = allProduct[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                selectedProduct = allProduct[0]
            }
        }

    }



    private fun clickAddProductBtn()
    {
        val product = Product.DefaultProduct( //todo id 0 сделать новую модель для ингридиента либо брать уже существующий продукт и к нему подписать кол-во
            id = 0,
            title = selectedProduct.title,
            productCategory = selectedProduct.productCategory,
            count = binding.countProduct.text.toString().toIntOrNull() ?: 1
        )

        productsInRecipe.add(product)
        productInRecipeAdapter.submitList(productsInRecipe)
        productInRecipeAdapter.notifyDataSetChanged() //todo сделать setdata
    }

    private fun clickSubmitBtn() // todo сделать проверку пустой ли
    {
        val category = categoryMap[binding.categorySpinner.selectedItem.toString()]
        val productList: List<ProductCreate> = productsInRecipe.map { it ->
            ProductCreate(
                title = it.title,
                productCategory = it.productCategory,
                isImportant = false,
                count = it.count,
                maxCount = null
            )
        }

        val recipe : RecipeCreate = RecipeCreate(
            title = binding.title.text.toString(),
            description = "Описания пока что нет",
            recipeCategory = category!!,
            productList = productList
        )


        mListener?.clickOnSubmit(recipe)
        dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setListener(listener: CreateRecipeBottomSheetListener) {
        mListener = listener
    }

    interface CreateRecipeBottomSheetListener {
        fun clickOnSubmit(result: RecipeCreate)
    }
}