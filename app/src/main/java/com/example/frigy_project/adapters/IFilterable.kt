package com.example.frigy_project.adapters

import android.widget.Filterable
import com.example.frigy_project.models.Product

interface IFilterable<T> : Filterable {

    fun setData(newList: List<T>)
}