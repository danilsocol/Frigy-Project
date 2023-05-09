package com.example.frigy_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.DialogFragment
import com.example.frigy_project.databinding.FragmentCreateProductBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
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
    }


    fun ClickSubmitBtn()
    {
        //todo обработка нажатия
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}