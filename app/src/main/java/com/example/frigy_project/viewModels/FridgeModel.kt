package com.example.frigy_project.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frigy_project.models.Product

class FridgeModel : ViewModel() {

    val products : MutableLiveData<List<Product>> by lazy {
        MutableLiveData<List<Product>>()
    }
}